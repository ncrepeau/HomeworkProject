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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GraphicPart extends Application {
	TextField textField;
	TextField searchTarget;
	GridPane myPane;
	String firstLine;
	String firstCue;
	Text myText;
	Text myText1;
	Text myTextPrevent;
	Text exceptionText;
	Scene scene;
	Text textCorrect;
	ImageView dog;
	TimerClass myTimer;
	int numCues;
	int numLines;
	String[] lineArray = new String[2];

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
		exceptionText = new Text();
		myPane.add(exceptionText, 0, 9);
		textField = new TextField();
		myPane.add(textField, 0, 1);
		Button nextButton = new Button("Next");
		nextButton.setOnAction(this::next);
		HBox button = new HBox(nextButton);
		myPane.add(button, 0, 2);
		Group root = new Group(myPane);
		scene = new Scene(root, 500, 500, Color.BLANCHEDALMOND);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void next(ActionEvent args) {
		try {
			firstCue = textField.getText();
			textField.clear();
			myText1.setText("Enter your line:");
			Button myButton = new Button("Show if correct");
			myButton.setOnAction(this::showAnswer);
			HBox answerButton = new HBox(myButton);
			myPane.add(answerButton, 0, 2);
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
			
		}
	}

	public void showAnswer(ActionEvent args) {
		try {
			firstLine = textField.getText();
			ArrayList<String> possibleAnswers = new ArrayList<String>();
			possibleAnswers.add("Congrats you got it right!");
			possibleAnswers.add("You got it wrong");
			lineArray[0] = firstCue;
			lineArray[1] = firstLine;
			Line myLine = new firstLine(lineArray[1], lineArray[0], possibleAnswers); // polymorphic call
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
			Button sort = new Button("Would you like to sort the lines");
			sort.setOnAction(this::sort);
			HBox sortButton = new HBox(sort);
			myPane.add(sortButton, 0, 3);
			Button search = new Button("Would you like to search for a line?");
			search.setOnAction(this::search);
			HBox searchButton = new HBox(search);
			myPane.add(searchButton, 0, 4);
			searchTarget = new TextField("Enter the line you would like to search for");
			myPane.add(searchTarget, 0, 5);
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}

	public void search(ActionEvent args) {
		try {
			Searching mySearch = new Searching();
			String target = searchTarget.getText();
			Text searchText = new Text("");
			myPane.add(searchText, 0, 6);
			if (mySearch.linearSearch(lineArray, target).equals(null)) {
				searchText.setText("This line exists");

			} else {
				searchText.setText("This line does not exist");
			}
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}

	public void sort(ActionEvent args) {
		try {
			Sorting mySort = new Sorting();
			mySort.selectionSort(lineArray);
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}

	public void listenUp(KeyEvent event) {
		try {
			KeyCode myCode = event.getCode();
			if (myCode == KeyCode.W) {
				myPane.add(dog, 7, 7);
				myTimer.stopTimer();
			}
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}

	public void paid(ActionEvent args) {
		try {
			String isPaid = textField.getText();
			if (!isPaid.matches("[a-zA-Z]")) {
				myTextPrevent = new Text("Please enter paid if you are a paid member");
				myPane.add(myText, 0, 8);
			}
			if (isPaid.equalsIgnoreCase("paid")) {
				myText1.setText("Enter the password");
				textField.clear();
				Button passButton = new Button("Enter Password");
				passButton.setOnAction(this::password);
				HBox passwordButton = new HBox(passButton);
				myPane.add(passwordButton, 0, 2);
			}
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}

	public void password(ActionEvent args) {
		try {
			String getPassword = textField.getText();
			if (!getPassword.matches("[a-zA-Z]")) {
				myTextPrevent.setText("Please enter a valid password");
			}
			if (getPassword.equalsIgnoreCase("password")) {
				textCorrect.setText("This is the paid section of this site!");
				textField.clear();
				myText1.setText("Enter number of cues!");
				Button cueButton = new Button("Enter");
				cueButton.setOnAction(this::cue);
				HBox numCueButton = new HBox(cueButton);
				myPane.add(numCueButton, 0, 2);
			}
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}

	public void cue(ActionEvent args) {
		try {
			numCues = Integer.parseInt(textField.getText());
			textField.clear();
			myText1.setText("Enter in how many lines you have!");
			Button statsButton = new Button("Show Statistics");
			statsButton.setOnAction(this::statistics);
			HBox statisticsButton = new HBox(statsButton);
			myPane.add(statisticsButton, 0, 2);
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}

	public void statistics(ActionEvent args) {
		try {
			numLines = Integer.parseInt(textField.getText());
			textField.clear();
			Statistics myStats = new Statistics(numCues, numLines);
			String stats = myStats.strStat();
			Text statText = new Text(stats);
			myPane.add(statText, 3, 0);
		} catch (NullPointerException ex) {
			exceptionText.setText("Please enter a valid respone");
		}
	}
}
