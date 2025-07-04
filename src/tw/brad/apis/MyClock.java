package tw.brad.apis;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public MyClock() {
		//setText("10:20:30");
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				LocalTime time = LocalTime.now();
				setText(time.format(formatter));
			}
		}, 0, 100);
	}
}
