import java.util.ArrayList;

public class firstLine extends Line {

	public firstLine(String firstCue, String firstLine, ArrayList<String> possibleAnswers) {
		super(firstCue, firstLine, possibleAnswers);
		this.firstCue = firstCue;
		this.firstLine = firstLine;
		this.possibleAnswers = possibleAnswers;
	}
	
	public String testLine(ArrayList<String> possibleAnswers) {
		if (firstLine.equals(firstCue)) {
			
			return (possibleAnswers.get(0));
		} else {
			return (possibleAnswers.get(1));
		}
}
	

}
