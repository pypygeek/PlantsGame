package game.pvsz.models.plants;

import game.pvsz.commons.PlantType;
import game.pvsz.controllers.Line;
import game.pvsz.models.lights.Light;
import game.pvsz.models.shots.Pea;
import game.pvsz.models.shots.Shot;
import game.pvsz.models.zombies.Zombie;

public class Sunflower extends Plant{
    public Sunflower(Line line) {
        super(line);
        this.life = 10;
        this.attackDelay = 10;
        this.type = PlantType.PRODUCTION;
        this.path = "/game/pvsz/images/plants/sunfloer/";
        this.frame ="1.png";
    }

    public void product() {

    }

    public void run() {
        int cnt = 0;
        while ((this.life > 0)) {
            try {
                this.frame = (cnt % 7 + 1) + ".png";

                Zombie target = this.line.getNearestZomvie(this);
                if(target != null) {
                    this.path = "/game/pvsz/images/plants/sunfloer/";
                    int delay = (this.attackDelay*1000)/3;
                    this.frame = "1.png";
                    Thread.sleep(delay);
                    this.frame = "2.png";
                    Thread.sleep(delay);
                    this.frame = "3.png";
                    Thread.sleep(delay);
                    this.product();
                    this.path = "/game/pvsz/images/plants/sunfloer/";
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
