package game.pvsz.models.shots;

import game.pvsz.commons.ShotType;
import game.pvsz.controllers.Line;
import game.pvsz.models.zombies.Zombie;

public class Snow extends Shot{
    public Snow(Line line, int x, int y) {
        super(line, x, y);
        this.attackPoint = 20;
        this.range = 0;
        this.type = ShotType.NOMAL;
    }
    public void run() {

    }

    public void attack() {

    }
}
