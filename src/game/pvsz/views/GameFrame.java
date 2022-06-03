package game.pvsz.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame {
	private JPanel contentPane;
	private BorderLayout borderLayout;
	
	public GameFrame() {
		super("PLANTS VS ZOMBIES");
		this.init();
	}

	private void init() {
		this.setVisible(true);
		this.borderLayout = new BorderLayout();
		this.contentPane = (JPanel) this.getContentPane();
		this.contentPane.setLayout(this.borderLayout);
		this.setSize(1000, 752);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameView gameView = new GameView();

		Thread thread = new Thread(gameView);
		thread.start();

		this.contentPane.add(gameView);
	}
	
}
