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
import javafx.scene.layout.VBox;
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
		
		startGame = new Button("Start");
		VBox start = new VBox(startGame);
		
		Color pokerGreen = Color.web("#477148");
		Color casinoYellow = Color.web("#C4B454");
		
		line1 = new Text("Welcome To");
		line2 = new Text("Baccarat");
		
	    Font font1 = Font.loadFont(BaccaratGame.class.getResourceAsStream("/Fonts/DeLatto-0W974.ttf"), 50);
	    Font font2 = Font.loadFont(BaccaratGame.class.getResourceAsStream("/Fonts/CasinoShadow-Italic.ttf"), 120);

	    line1.setFont(font1);
	    line1.setX(210);
	    line1.setY(120);
	    
	    line1.setStrokeWidth(1);
	    line1.setStroke(casinoYellow);
	    
	    line2.setFont(font2);
	    line2.setX(140);
	    line2.setY(250);
	    
	    line2.setStrokeWidth(3);
	    line2.setStroke(Color.BLACK);
	    line2.setFill(casinoYellow);
	    
	    Group welcomeMsg = new Group(line1, line2);
	    
		primaryStage.setTitle("Welcome to Baccarat");

//		BorderPane root = new BorderPane();
//		root.setCenter(welcomeMsg);
		
		Scene scene = new Scene(welcomeMsg, 800, 600);
		
		scene.setFill(pokerGreen);
		
		primaryStage.setScene(scene);
		primaryStage.show();
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
