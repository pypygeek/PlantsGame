package game.pvsz.models.zombies;

import game.pvsz.controllers.Line;
import game.pvsz.models.plants.Plant;

public class BasicZombie extends Zombie{
    public BasicZombie(Line line) {
        super(line);
        this.life = 100;
        this.attackPoint = 1;
        this.attackRange = 10;
        this.speed = 10;
        this.path = "/game/pvsz/images/zombies/basic/";
        this.frame = "1.png";
    }


    public void run() {
        int cnt = 1;
        while (this.life > 0) {
            try {
                this.frame = (cnt % 8 + 1) + ".png";
                cnt++;
                if (cnt % 5 == 0) {
                    Plant[] plants = this.line.getPlants();
                    Plant food = null;
                    for (Plant plant : plants) {
                        if (plant != null && (this.getX() - plant.getX()) <= this.attackRange) {
                            food = plant;
                            break;
                        }
                    }
                    if (food == null) {
                        this.walk();
                    } else {
                        this.eatFood(food);
                    }
                }
                cnt++;
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.line.removeZombie(this);
    }
}
