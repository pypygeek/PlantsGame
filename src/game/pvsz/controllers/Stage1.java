package game.pvsz.controllers;

import game.pvsz.commons.ZombieType;
import game.pvsz.controllers.GameController;
import game.pvsz.controllers.Stage;

public class Stage1 implements Stage {
    private GameController gameController;


    public Stage1(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void startStage() throws InterruptedException {
        System.out.println("Stage 1 start.");
        Thread.sleep(20000);
    }

    @Override
    public void runningStage() throws InterruptedException {
        this.gameController.addZombie(ZombieType.BASIC);
    }

    @Override
    public void endStage() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Stage 1 Completed.");
    }
}
