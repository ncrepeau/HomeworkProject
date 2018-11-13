import java.util.ArrayList;

public class secondLine extends Line {

	public secondLine(String firstCue, String firstLine, ArrayList<String> possibleAnswers) {
		super(firstCue, firstLine, possibleAnswers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String testLine(ArrayList<String> possibleAnswers) {
		if (firstLine.equals(firstCue)) {
			return (possibleAnswers.get(0));
		} else {
			return (possibleAnswers.get(1));
		}
	}

}
