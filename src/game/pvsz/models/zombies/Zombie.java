package game.pvsz.models.zombies;

import javax.swing.*;

import game.pvsz.commons.Position;
import game.pvsz.controllers.Line;
import game.pvsz.models.plants.Plant;

import java.awt.*;

public abstract class Zombie extends JLabel implements Runnable {
    protected int life;
    protected int attackPoint;
    protected int attackRange;
    protected int speed;
    protected String path;
    protected String frame;

    protected Line line;

    public Zombie(Line line) {
        this.line = line;
        this.setBounds(0, 0, 62, 100);
    }

    public void slowMin() {
        speed -= 3;
        InitS();
    }

    public void InitS() {
        speed = +3;
    }

    protected void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon((this.getClass().getResource(this.path + this.frame)));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

    public int getLife() {
        return life;
    }
     public int getAttackPoint() {
        return attackPoint;
    }
    public int getAttackRange() {
        return attackRange;
    }
    public int getSpeed() {
        return speed;
    }


    public void reduceLife(int attackPoint) {
        this.life -= attackPoint;
    }
    public void walk() {
        this.setLocation(this.getX() - this.speed, this.getY());
        if (this.getX() == 0) {
            System.out.println("GameOver!!!!!");
            System.exit(0);
        }
    }

    public void eatFood(Plant plant) {
        plant.reduceLife(this.attackPoint);
    }

    public abstract void run();

}