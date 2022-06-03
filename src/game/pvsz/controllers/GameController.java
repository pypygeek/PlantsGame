package game.pvsz.controllers;

import javax.swing.text.PlainView;

import game.pvsz.commons.*;
import game.pvsz.models.card.Card;
import game.pvsz.models.lights.Light;
import game.pvsz.models.plants.Plant;
import game.pvsz.models.plants.SnowPea;
import game.pvsz.models.zombies.BasicZombie;
import game.pvsz.models.zombies.BucketZombie;
import game.pvsz.models.zombies.ConeheadZombie;
import game.pvsz.models.zombies.Zombie;
import game.pvsz.views.GameFrame;
import game.pvsz.views.GameView;
import game.pvsz.views.SunBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController implements Runnable {
    private Line[] lines;
    private List<Stage> stages;
    private GameView gameView;
    private List<Light> lights;
    private Card selectedCard;
    private int score;
    private Line line;

    public GameController(GameView gameView) {
        this.lines = new Line[5];
        for(int i = 0; i<lines.length; i++) {
            this.lines[i] = new Line(this);
        }

        this.stages = new ArrayList<Stage>();
        this.stages.add(new Stage1(this));
        this.lights = new ArrayList<Light>();
        this.score = 50;

        this.gameView = gameView;

        this.changeSunBoard();

    }

    public void addScore(Light light) {
        this.score += light.getScore();
        this.changeSunBoard();
    }

    private void changeSunBoard() {
        SunBoard sunBoard = (SunBoard) this.gameView.getSunBoard();
        sunBoard.changeSunBoardScore(this.score);
    }

    public void addZombie(ZombieType zombieType) {
        Random random = new Random();
        int lineNo = random.nextInt(5);
        Zombie zombie = ZombieFactory.createZombie(zombieType, this.lines[lineNo]);
        zombie.setLocation(900, Utils.getYFromIdx(lineNo));
        Thread thread = new Thread(zombie);
        thread.start();
    }


    public void addPlant(int x, int y) {
        if (this.selectedCard == null) {
            return;
        }

        int lineNo = Utils.getYIndex(y);
        int idx = Utils.getXIndex(x);
        Plant plant = PlantFactory.createPlant(this.selectedCard, this.lines[lineNo]);
        this.lines[lineNo].addPlant(plant, idx);

        int posX = Utils.getYFromIdx(idx);
        int posY = Utils.getYFromIdx(lineNo);
        plant.setLocation(posX, posY);
        this.gameView.add(plant);

        Thread thread = new Thread(plant);
        thread.start();

        this.score -= this.selectedCard.getScore();

        SunBoard sunBoard = (SunBoard) this.gameView.getSunBoard();
        sunBoard.changeSunBoardScore(this.score);

        this.selectedCard = null;

        Zombie zombie = new BasicZombie(this.lines[0]);
        zombie.setLocation(800, 70);
        this.lines[0].addZombie(zombie);
        Thread t = new Thread(zombie);
        t.start();
    }

    public GameView getGameView() {
        return gameView;
    }

    public void productLight() {

    }
    public void addLight(Light light) {
        this.lights.add(light);
        this.gameView.add(light);
    }
    public void removeLight (Light light) {
        this.lights.remove(light);
        this.gameView.remove(light);
    }
    public void selectCard(Card card) {
        this.selectedCard = card;
    }

    public boolean isCompleteStage() {
        for(Line line : this.lines) {
            if(line.getZombies().size() > 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        for(Stage stage : this.stages) {
            try {
                stage.startStage();
                stage.runningStage();
                while (!this.isCompleteStage()) {
                    Thread.sleep(100);
                }
                if(this.isCompleteStage()) {
                    stage.endStage();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All Stage Complete!!");
    }

    private void gf() {
    }

}
