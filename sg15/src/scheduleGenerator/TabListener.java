package scheduleGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabListener implements ActionListener {

	private Day day;
	private Config con;
	
	public TabListener (Config con, Day day) {
		this.day = day;
		this.con = con;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.con.dayCheckActionPerformed(this.day);

	}

}
