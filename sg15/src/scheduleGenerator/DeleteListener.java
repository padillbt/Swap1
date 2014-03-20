package scheduleGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// SWAP 1, TEAM 6
// QUALITY CHANGES
public class DeleteListener implements ActionListener {

	private Day day;
	
	public DeleteListener (Day day){
		this.day = day;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.day.delete();

	}

}
