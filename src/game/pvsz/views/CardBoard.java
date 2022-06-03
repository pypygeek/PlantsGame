package game.pvsz.views;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.pvsz.models.card.*;

public class CardBoard extends JPanel {
	private GameView gameView;


	public CardBoard(GameView gameView) {
		this.gameView = gameView;
		this.setBounds(109, 10, 450, 84);
		this.setOpaque(false);
		this.setLayout(new GridLayout(1, 6, 3, 0));

		this.add(new SunflowerCard((this)));
		this.add(new PeaShooterCard((this)));
		this.add(new SnowPeaCard(this));
		this.add(new CherryBombCard((this)));
		this.add(new WalnutCard((this)));
		JLabel empty = new JLabel();
		this.add(empty);
	}
	public GameView getGameView() {
		return this.gameView;
	}

}
