package game.pvsz.controllers;

import java.util.ArrayList;
import java.util.List;

import game.pvsz.models.plants.Plant;
import game.pvsz.models.shots.Shot;
import game.pvsz.models.zombies.Zombie;

public class Line {
    private Plant[] plants;
    private List<Zombie> zombies;
    private List<Shot> shots;
    private GameController controller;

    public Line(GameController gameController) {
        this.plants = new Plant[9];
        this.zombies = new ArrayList<>();
        this.controller = gameController;
        this.shots = new ArrayList<Shot>();
    }

    public void addShot(Shot shot) {
        this.shots.add(shot);
        this.controller.getGameView().add(shot);
    }

    public void removeShot(Shot shot) {
        this.shots.remove(shot);
        this.controller.getGameView().remove(shot);
    }

    public void removeShot(Short shot) {

    }

    public Plant[] getPlants() {
        return plants;
    }
    public List<Zombie> getZombies() {
        return zombies;
    }


    public GameController getController() {
        return controller;
    }

    public void addPlant(Plant plant, int idx) {
        this.plants[idx] = plant;
    }

    public void removePlant (Plant plant) {
        for(int i = 0; i<plants.length; i++) {
            if(this.plants[i] == plant) {
                this.plants[i] = null;
                this.controller.getGameView().remove(plant);
            }
        }
    }

    public void addZombie(Zombie zombie) {
        this.zombies.add(zombie);
        this.controller.getGameView().add(zombie);
    }

    public void removeZombie(Zombie zombie) {
        this.zombies.remove(zombie);
        this.controller.getGameView().remove(zombie);
    }

    public Zombie getNearestZomvie(Plant plant) {
        int min = 9999;
        Zombie result = null;
        for (Zombie zombie : this.zombies) {
            if(zombie.getX()-plant.getX() < min) {
                min = zombie.getX() - plant.getX();
                result = zombie;
            }
        }
        return result;
    }


}
