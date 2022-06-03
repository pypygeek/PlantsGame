package game.pvsz.models.plants;
import javax.swing.*;

import game.pvsz.commons.PlantType;
import game.pvsz.commons.Position;
import game.pvsz.controllers.Line;

import java.awt.*;

public abstract class Plant extends JLabel implements Runnable{
    protected int life;
    protected int attackDelay;
    protected Position position;
    protected PlantType type;
    protected String path;
    protected String frame;

    protected Line line;

    public Plant(Line line) {
        this.line = line;
        this.setBounds(0, 0, 74, 74);
    }

    public void reduceLife(int attackPoint) {
        this.life -= attackPoint;
    }

    public int getLife() {
        return life;
    }
    public int getAttackDelay() {
        return attackDelay;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void productLight() {

    }

    public abstract void product();
    public abstract void run();

    protected void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon((this.getClass().getResource(this.path+this.frame)));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

}
