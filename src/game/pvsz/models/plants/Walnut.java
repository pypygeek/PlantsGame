package game.pvsz.models.plants;

import game.pvsz.commons.PlantType;
import game.pvsz.controllers.Line;
import game.pvsz.models.shots.Pea;
import game.pvsz.models.shots.Shot;
import game.pvsz.models.zombies.Zombie;

public class Walnut extends Plant{
    public Walnut(Line line) {
        super(line);
        this.life = 100;
        this.attackDelay = 0;
        this.type = PlantType.DEFFECE;
        this.path = "/game/pvsz/images/plants/wallnut/";
        this.frame = "1.png";
    }

    public void product() {
        Shot shot = new Pea(this.line, this.getX()+40, this.getY()+5);
        this.line.addShot(shot);
        Thread thread = new Thread(shot);
        thread.start();
    }

    public void run() {
        int cnt = 0;
        while ((this.life > 0)) {
            try {
                this.frame = (cnt % 3 + 1) + ".png";

                Zombie target = this.line.getNearestZomvie(this);
                if(target != null) {
                    this.path = "/game/pvsz/images/plants/wallnut/";
                    int delay = (this.attackDelay*1000)/3;
                    this.frame = "1.png";
                    Thread.sleep(delay);
                    this.frame = "2.png";
                    Thread.sleep(delay);
                    this.frame = "3.png";
                    Thread.sleep(delay);
                    this.product();
                    this.path = "/game/pvsz/images/plants/wallnut/";
                }
                cnt++;
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.line.removePlant(this);
    }

}
