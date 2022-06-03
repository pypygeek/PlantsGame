package game.pvsz.models.shots;

import java.util.List;

import game.pvsz.commons.ShotType;
import game.pvsz.controllers.Line;
import game.pvsz.models.zombies.Zombie;

public class Pea extends Shot{
    public Pea(Line line, int x, int y) {
        super(line, x, y);
        this.attackPoint = 20;
        this.range = 0;
        this.type = ShotType.NOMAL;
        this.path = "/game/pvsz/images/shots/pea.png";
    }
    public void run() {
        flag : while (this.getX() <= 900) {
            try {
                this.setLocation(this.getX()+10, this.getY());
                List<Zombie> zombies = this.line.getZombies();
                for(Zombie zombie : zombies) {
                    if(zombie.getX() < this.getX()) {
                        zombie.reduceLife(this.attackPoint);
                        break flag;
                    }
                }
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.line.removeShot(this);
    }

    public void attack() {

    }
}

