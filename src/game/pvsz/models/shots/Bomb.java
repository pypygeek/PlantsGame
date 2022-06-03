package game.pvsz.models.shots;

import game.pvsz.commons.ShotType;
import game.pvsz.controllers.Line;
import game.pvsz.models.zombies.Zombie;

public class Bomb extends Shot{
    public Bomb(Line line, int x, int y) {
        super(line, x, y);
        this.attackPoint = 20;
        this.range = 0;
        this.type = ShotType.BOMB;
    }

    public void run() {

    }

    public void attack() {

    }
}
