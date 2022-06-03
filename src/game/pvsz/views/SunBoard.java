package game.pvsz.views;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SunBoard extends JLabel {

	public SunBoard() {
		super("0");
		this.setBounds(25, 73, 70, 25);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void changeSunBoardScore(int score) {
		this.setText(score+"");
	}
}
