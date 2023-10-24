import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group; 

import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;




public class BaccaratGame extends Application {

	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	private BaccaratDealer theDealer;
	private BaccaratGameLogic gameLogic;
	private double currentBet;
	private double totalWinnings;
	
	private Button fiveDollarChip, twentyFiveDollarChip, 
	hundredDollarChip, fiveHundredDollarChip;
	
	private Button dealButton; // turns into draw once bets are placed
	private Button clearBetButton;
	
	private Button tieBet, bankerBet, playerBet;
	
	private Button startGame;
	
	private VBox welcome;
	
	private TextField balance, wager, winnings, welcomeMsg;
	
	private Text line1, line2;
	
	private EventHandler<ActionEvent> handler;
	

	
//	public double evaluateWinnings() {
//		
//	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("It's Baccarat Time!");
		
		// START OF TEXT
		Color pokerGreen = Color.web("#477148");
		Color casinoYellow = Color.web("#C4B454");
		
		line1 = new Text("Time to Play");
		line2 = new Text("Baccarat");
		
	    Font script = Font.loadFont(BaccaratGame.class.getResourceAsStream("/Fonts/DeLatto-0W974.ttf"), 50);
	    Font casino = Font.loadFont(BaccaratGame.class.getResourceAsStream("/Fonts/CasinoShadow-Italic.ttf"), 120);
	    Font buttonScript = Font.loadFont(BaccaratGame.class.getResourceAsStream("/Fonts/DeLatto-0W974.ttf"), 18);

	    line1.setFont(script);
	    line1.setTranslateX(325);
	    line1.setTranslateY(80);
	
	    line1.setStrokeWidth(1);
	    line1.setStroke(casinoYellow);
	    
	    line2.setFont(casino);
	    line2.setTranslateX(250);
	    line2.setTranslateY(70);
	    
	    line2.setStrokeWidth(3);
	    line2.setStroke(Color.BLACK);
	    line2.setFill(casinoYellow);
	    
	    VBox lines = new VBox(line1, line2);
	    
	    // END OF TEXT
	    
	    // START OF BUTTON
	    
	    startGame = new Button("Play Game");
	    startGame.setFont(buttonScript);
	    startGame.setPrefSize(280, 55);
	    startGame.setTranslateX(0);
	    startGame.setTranslateY(60);
	    
	    BorderPane temp = new BorderPane();
	    Scene gameplayScreen = new Scene(temp, 800, 600);
	    startGame.setOnAction(e -> primaryStage.setScene(gameplayScreen));
	    primaryStage.show();
	    
	    // END OF BUTTON
	    
	    // START OF IMAGES
	    Image chips = new Image(new FileInputStream("src/main/resources/Pictures/chipStack.png"));
	    Image cards = new Image(new FileInputStream("src/main/resources/Pictures/cards.png"));
	    
	    ImageView chipView = new ImageView(chips);
	    ImageView cardView = new ImageView(cards);
	    
	    chipView.setFitHeight(400);
	    chipView.setFitWidth(400);
	    chipView.setTranslateX(200);
	    chipView.setTranslateY(-10);
	    
	    cardView.setTranslateX(0);
	    cardView.setTranslateY(-100);
	    cardView.setFitHeight(400);
	    cardView.setFitWidth(400);
	    	
	    HBox chipsImage = new HBox(chipView);
	    
	    HBox cardsImage = new HBox(cardView);
	    
	    HBox images = new HBox(cardsImage, chipsImage);
	    
	    // END OF IMAGES
	    
		VBox welcomeMsg = new VBox(lines, startGame, images);	 
		welcomeMsg.setAlignment(Pos.TOP_CENTER);
		welcomeMsg.setSpacing(80);
		
		BorderPane root = new BorderPane(welcomeMsg);
		
		Scene scene = new Scene(root, 1000, 800);
		
		BackgroundFill backgroundFill = new BackgroundFill(pokerGreen, null, null);
	    Background background = new Background(backgroundFill);
	    root.setBackground(background);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public Scene createScene() {
		BorderPane temp = new BorderPane();
		return new Scene(temp, 800, 600);
	}
	
	
	
	//	feel free to remove the starter code from this method
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		primaryStage.setTitle("Welcome to JavaFX");
//		
//		 Rectangle rect = new Rectangle (100, 40, 100, 100);
//	     rect.setArcHeight(50);
//	     rect.setArcWidth(50);
//	     rect.setFill(Color.VIOLET);
//
//	     RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
//	     rt.setByAngle(270);
//	     rt.setCycleCount(4);
//	     rt.setAutoReverse(true);
//	     SequentialTransition seqTransition = new SequentialTransition (
//	         new PauseTransition(Duration.millis(500)),
//	         rt
//	     );
//	     seqTransition.play();
//	     
//	     FadeTransition ft = new FadeTransition(Duration.millis(5000), rect);
//	     ft.setFromValue(1.0);
//	     ft.setToValue(0.3);
//	     ft.setCycleCount(4);
//	     ft.setAutoReverse(true);
//
//	     ft.play();
//	     BorderPane root = new BorderPane();
//	     root.setCenter(rect);
//	     
//	     Scene scene = new Scene(root, 700,700);
//			primaryStage.setScene(scene);
//			primaryStage.show();	
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
