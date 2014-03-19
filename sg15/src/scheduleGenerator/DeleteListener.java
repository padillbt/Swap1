package scheduleGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {

	private Day day;
	
	public DeleteListener (Day day){
		this.day = day;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.day.DeleteJob();

	}

}
