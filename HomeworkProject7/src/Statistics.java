
public class Statistics {
	private double totalMem;
	private double numPerHour;
	private int numCues;
	private int numLines;

	public Statistics(int numCues, int numLines) {
		this.numCues = numCues;
		this.numLines = numLines;
	}

	public String strStat() {
		totalMem = numCues + numLines;
		numPerHour = totalMem / 60;
		double numPerHour2 = Math.ceil(numPerHour);
		return ("You have " + numCues + " cues, and " + numLines + "." + "\n" + "You have " + totalMem
				+ " lines to memorize!" + "\n" + "You need to memorize " + numPerHour2
				+ " lines per minute to memorize them all in one hour!");

	}
}
