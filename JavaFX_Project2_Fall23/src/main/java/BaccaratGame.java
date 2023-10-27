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
	    
	   // BorderPane temp = new BorderPane();
	    //Scene gameplayScreen = new Scene(temp, 800, 600);
	    startGame.setOnAction(e -> primaryStage.setScene(createGameScene()));
	    primaryStage.show();
	    
	    // END OF BUTTON
	    
	    // START OF IMAGES
	    Image chips = new Image(new FileInputStream("src/main/resources/Pictures/Chips_Pic.png"));
	    Image cards = new Image(new FileInputStream("src/main/resources/Pictures/Card Pictures.png"));
	    
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
	
	
	
	public Scene createGameScene() {
		
		Color casinoYellow = Color.web("#C4B454");
		Font casino = Font.loadFont(BaccaratGame.class.getResourceAsStream("/Fonts/CasinoShadow-Italic.ttf"), 35);

			//Button 1 
			Image fiveChip = new Image("Pictures/FiveDollarChip.png");
			ImageView v1 = new ImageView(fiveChip);
			//v1.setFitHeight(100);
			//v1.setFitWidth(100);
			v1.setFitHeight(50);
			v1.setPreserveRatio(true);
			
			//Creating the Buttons for the Chips
			Button fiveButton = new Button();
			fiveButton.setPrefSize(50, 50);
			//fiveButton.setTranslateX(0);
			//fiveButton.setTranslateY(300);
			fiveButton.setGraphic(v1);
			
			//Button 2
			Image twentyFive_Chip = new Image("Pictures/TwentyFiveDollarChip.png");
			ImageView v2 = new ImageView(twentyFive_Chip);
			v2.setFitHeight(50);
			v2.setPreserveRatio(true);
			
			Button twentyFive_B = new Button();
			twentyFive_B.setPrefSize(50, 50);
			//twentyFive_B.setTranslateX(0);
			//twentyFive_B.setTranslateY(300);
			twentyFive_B.setGraphic(v2);
			// Chip 25 is done ^^^^^^^^^
			
			//Button 3
			Image hundredChip = new Image("Pictures/HundredChip.png");
			ImageView v3 = new ImageView(hundredChip);
			v3.setFitHeight(50);
			v3.setPreserveRatio(true);
			
			Button hundredButton = new Button();
			hundredButton.setPrefSize(50, 50);
			//hundredButton.setTranslateX(0);
			//hundredButton.setTranslateY(300);
			hundredButton.setGraphic(v3);
			
			// Button 3
			Image five_Hundred_Chip = new Image("Pictures/FiveHundredChip.png");
			ImageView v4 = new ImageView(five_Hundred_Chip);
			v4.setFitHeight(50);
			v4.setPreserveRatio(true);
			
			//Button 4
			Button fiveHundred_B = new Button();
			fiveHundred_B.setPrefSize(50, 50);
			//fiveHundred_B.setTranslateX(0);
			//fiveHundred_B.setTranslateY(300);
			fiveHundred_B.setGraphic(v4);
			// Buttons finish
			
			Text gamePlayer = new Text("Player");
				gamePlayer.setTranslateX(210);
			    gamePlayer.setTranslateY(25);
			    gamePlayer.setStrokeWidth(1);
			    gamePlayer.setFill(casinoYellow);
			    gamePlayer.setFont(casino);
			    gamePlayer.setStroke(Color.BLACK);
		   
		    
		    Text dealerPlayer = new Text("Dealer");
		    dealerPlayer.setTranslateX(400);
		    dealerPlayer.setTranslateY(25);
		    dealerPlayer.setStrokeWidth(1);
		    dealerPlayer.setFill(casinoYellow);
		    dealerPlayer.setFont(casino);
		    dealerPlayer.setStroke(Color.BLACK);
		    HBox gameText = new HBox(gamePlayer, dealerPlayer);
		    

		    // Adjust the Y translation to position it as desired
		    
			
		    
			Rectangle rectangle = new Rectangle(800,60); // button menu dark green
			rectangle.setFill(Color.DARKGREEN);	
			
			
			VBox buttonContainer = new VBox(6, gameText, fiveButton, twentyFive_B, hundredButton, fiveHundred_B, rectangle);
			buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
			buttonContainer.setStyle("-fx-background-color:#477148;");
			
			
			
			return new Scene(buttonContainer, 800,600);
			
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}