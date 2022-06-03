package game.pvsz.views;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.pvsz.controllers.GameController;

public class GameView extends JPanel implements Runnable{
	private JLabel sunBoard;
	private JPanel cardBoard;
	private GameController gameController;
	
	public GameView() {
		init();
		this.gameController = new GameController(this);
		Thread thread = new Thread(this.gameController);
		thread.start();
	}

	public GameController getGameController() {
		return this.gameController;
	}
	
	private void init() {
		this.setSize(1000, 752);
		this.setLayout(null);
		this.sunBoard = new SunBoard();
		this.add(this.sunBoard);
		this.cardBoard = new CardBoard(this);
		this.add(this.cardBoard);
		this.addMouseListener(new GameViewListener());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/game/pvsz/images/mainBG.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public JLabel getSunBoard() {
		return this.sunBoard;
	}

	private class GameViewListener extends MouseAdapter {
		public  void mousePressed(MouseEvent e) {
			if(e.getX() < 50 || e.getX() > 940 || e.getY() < 110 || e.getY() > 690) {
				return;
			}
			gameController.addPlant(e.getX(), e.getY());
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
	
}
