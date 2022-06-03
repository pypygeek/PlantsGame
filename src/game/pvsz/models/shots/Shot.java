package game.pvsz.models.shots;

import javax.swing.*;

import game.pvsz.commons.ShotType;
import game.pvsz.controllers.Line;
import game.pvsz.models.zombies.Zombie;

import java.awt.*;

public abstract class Shot extends JLabel implements Runnable{
    protected int attackPoint;
    protected int range;
    protected ShotType type;
    protected String path;

    protected Line line;

    public Shot (Line line, int x, int y) {
        this.line = line;
        this.setBounds(x, y, 28, 28);
    }

    protected void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon((this.getClass().getResource(this.path)));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public int getRange() {
        return range;
    }

    public abstract void run();
    public abstract void attack();
}
