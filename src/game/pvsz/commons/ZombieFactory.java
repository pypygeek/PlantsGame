package game.pvsz.commons;

import game.pvsz.controllers.Line;
import game.pvsz.models.zombies.BasicZombie;
import game.pvsz.models.zombies.BucketZombie;
import game.pvsz.models.zombies.ConeheadZombie;
import game.pvsz.models.zombies.Zombie;

public class ZombieFactory {
    public static Zombie createZombie(ZombieType zombieType, Line line) {
        switch (zombieType) {
            case BASIC:
                return new BasicZombie(line);
            case CONHEAD:
                return new ConeheadZombie(line);
            case BUCKET:
                return new BucketZombie(line);
            default:
                return null;
        }
    }
}
