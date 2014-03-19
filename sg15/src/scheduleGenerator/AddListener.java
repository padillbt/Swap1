package scheduleGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener {

	private Day day;
	
	public AddListener (Day day) {
		this.day = day;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.day.addJob();
	}

}
