import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GraphicPart extends Application {
	TextField textField;
	GridPane myPane;
	String firstLine;
	String firstCue;
	Text myText;
	Text myText1;
	Scene scene;
	Text textCorrect;
	ImageView dog;
	TimerClass myTimer;
	int numCues;
	int numLines;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Image dogImage = new Image("file:src/mydog.png");
		dog = new ImageView(dogImage);
		myPane = new GridPane();
		myPane.setHgap(10);
		myPane.setVgap(10);
		textCorrect = new Text("");
		myPane.add(textCorrect, 1, 1);
		myText1 = new Text("Enter your cue!");
		myPane.add(myText1, 0, 0);
		textField = new TextField();
		myPane.add(textField, 0, 1);
		Button nextButton = new Button("Next");
		nextButton.setOnAction(this::next);
		HBox button = new HBox(nextButton);
		myPane.add(button, 0, 2);
		Group root = new Group(myPane);
		scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void next(ActionEvent args) {
		firstCue = textField.getText();
		textField.clear();
		myText1.setText("Enter your line:");
		Button myButton = new Button("Show if correct");
		myButton.setOnAction(this::showAnswer);
		HBox answerButton = new HBox(myButton);
		myPane.add(answerButton, 0, 2);
	}

	public void showAnswer(ActionEvent args) {
		firstLine = textField.getText();
		ArrayList<String> possibleAnswers = new ArrayList<String>();
		possibleAnswers.add("Congrats you got it right!");
		possibleAnswers.add("You got it wrong");
		firstLine myLine = new firstLine(firstCue, firstLine, possibleAnswers);
		String ifCorrect = myLine.testLine(possibleAnswers);
		textCorrect.setText(ifCorrect);
		textField.clear();
		myText1.setText("Are you a paid member of this site? Enter paid if so");
		Button paidButton = new Button("Click when done");
		paidButton.setOnAction(this::paid);
		HBox paidButton1 = new HBox(paidButton);
		myPane.add(paidButton1, 0, 2);
		myTimer = new TimerClass();
		scene.setOnKeyPressed(this::listenUp);
	}
	public void listenUp(KeyEvent event) {
		KeyCode myCode = event.getCode();
		if(myCode == KeyCode.W) {
			myPane.add(dog, 3, 3);
			myTimer.stopTimer();
		}
	}
	public void paid(ActionEvent args) {
		String isPaid = textField.getText();
		if(isPaid.equalsIgnoreCase("paid")) {
			myText1.setText("Enter the password");
			textField.clear();
			Button passButton = new Button("Enter Password");
			passButton.setOnAction(this::password);
			HBox passwordButton = new HBox(passButton);
			myPane.add(passwordButton, 0, 2);
		}
		
	}
	public void password(ActionEvent args) {
		String getPassword = textField.getText();
		if(getPassword.equalsIgnoreCase("password")) {
			textCorrect.setText("This is the paid section of this site!");
			textField.clear();
			myText1.setText("Enter number of cues!");
			Button cueButton = new Button("Enter");
			cueButton.setOnAction(this::cue);
			HBox numCueButton = new HBox(cueButton);
			myPane.add(numCueButton, 0, 2);
		}
	}
	public void cue(ActionEvent args) {
		numCues = Integer.parseInt(textField.getText());
		textField.clear();
		myText1.setText("Enter in how many lines you have!");
		Button statsButton = new Button("Show Statistics");
		statsButton.setOnAction(this::statistics);
		HBox statisticsButton = new HBox(statsButton);
		myPane.add(statisticsButton, 0, 2);
	}
	public void statistics(ActionEvent args) {
		numLines = Integer.parseInt(textField.getText());
		textField.clear();
		Statistics myStats = new Statistics(numCues, numLines);
		String stats = myStats.strStat();
		Text statText = new Text(stats);
		myPane.add(statText, 3, 0);
	}

}
