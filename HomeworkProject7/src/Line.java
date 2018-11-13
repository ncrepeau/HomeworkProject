import java.util.ArrayList;

public abstract class Line implements InterfaceLine {
	protected String firstCue;
	protected String firstLine;
	protected ArrayList<String> possibleAnswers;

	public Line(String firstCue, String firstLine, ArrayList<String> possibleAnswers) {
		this.firstCue = firstCue;
		this.firstLine = firstLine;
		this.possibleAnswers = possibleAnswers;
	}

	/* (non-Javadoc)
	 * @see InterfaceLine#testLine(java.util.ArrayList)
	 */
	@Override
	public abstract String testLine(ArrayList<String> possibleAnswers);
}
