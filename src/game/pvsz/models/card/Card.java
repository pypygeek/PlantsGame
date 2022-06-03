package game.pvsz.models.card;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import game.pvsz.views.CardBoard;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Card extends JLabel {
    protected int score;
    protected int cooldownTime;
    protected String path;

    protected CardBoard cardBoard;

    public Card(CardBoard cardBoard) {
        this.cardBoard = cardBoard;
        this.setBounds(0, 0, 64, 90);
        this.addMouseListener(new CardMouseListener());
    }

    public int getScore() {
        return score;
    }
    public int getCooldownTime() {
        return cooldownTime;
    }

    protected void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon((this.getClass().getResource(this.path)));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

    private class CardMouseListener extends MouseAdapter {

        public  void mousePressed(MouseEvent e) {
            Component[] components = cardBoard.getComponents();
            for(Component comp : components) {
                JLabel label = (JLabel) comp;
                label.setBorder(null);
            }
            Card card = (Card) e.getSource();
            card.setBorder(new BevelBorder(BevelBorder.RAISED));

            cardBoard.getGameView().getGameController().selectCard(card);
        }
    }
}
