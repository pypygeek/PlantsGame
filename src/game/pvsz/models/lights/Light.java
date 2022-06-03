package game.pvsz.models.lights;

import javax.swing.*;

import game.pvsz.controllers.GameController;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Light extends JLabel implements Runnable {
    private int score;
    private GameController controller;
    private String path;
    private boolean fromPlant;


    public Light(GameController gameController, boolean fromPlant) {
        this.score = 25;
        this.controller = gameController;
        this.setBounds(0, 0, 80, 80);
        this.fromPlant = fromPlant;
        this.addMouseListener(new LightMouseListener());
        this.path = "/game/pvsz/images/lights/sun.png";
    }

    class LightMouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            clicked();
        }
    }

    public int getScore() {
        return score;
    }

    public void clicked() {
        this.controller.addScore(this);
        this.controller.removeLight(this);
    }


    protected void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon((this.getClass().getResource(this.path)));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

    @Override
    public void run() {
        try {
            if (fromPlant) {
                Thread.sleep(5000);
            } else {
                Random rand = new Random();
                this.setLocation(100 + rand.nextInt(700), 0);
                int cnt = 0;
                while (++cnt <= 50) {
                    if (this.getY() < 400) {
                        this.setLocation(this.getX(), this.getY() + 5);
                        Thread.sleep(100);
                    }
                }
            }
            this.controller.removeLight(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
