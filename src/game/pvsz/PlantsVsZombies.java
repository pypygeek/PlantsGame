package game.pvsz;

import javax.swing.SwingUtilities;

import game.pvsz.views.GameFrame;

public class PlantsVsZombies {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GameFrame();
			}
		});
	}

}
