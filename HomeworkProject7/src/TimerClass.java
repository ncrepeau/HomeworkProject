import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerClass {
	Timer myTimer;

	public TimerClass() {
		myTimer = new Timer(500, new myTimeHandler());
		myTimer.start();
	}

	public void stopTimer() {
		myTimer.stop();
	}

	private class myTimeHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Press W for a dog!");
		}

	}
}
