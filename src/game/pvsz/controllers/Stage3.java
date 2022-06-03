package game.pvsz.controllers;

import game.pvsz.commons.ZombieType;
import game.pvsz.controllers.GameController;
import game.pvsz.controllers.Stage;

public class Stage3 implements Stage {
    private GameController gameController;

    public Stage3(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void startStage() throws InterruptedException {
        System.out.println("Stage 3 start.");
        Thread.sleep(20000);
    }

    @Override
    public void runningStage() throws InterruptedException {
        this.gameController.addZombie(ZombieType.BASIC);
        this.gameController.addZombie(ZombieType.CONHEAD);
        this.gameController.addZombie(ZombieType.BUCKET);
    }

    @Override
    public void endStage() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Stage 3 Completed.");
    }
}
