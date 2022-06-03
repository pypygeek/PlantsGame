package game.pvsz.commons;

import game.pvsz.controllers.Line;
import game.pvsz.models.card.Card;
import game.pvsz.models.card.CherryBombCard;
import game.pvsz.models.card.PeaShooterCard;
import game.pvsz.models.card.SnowPeaCard;
import game.pvsz.models.card.SunflowerCard;
import game.pvsz.models.card.WalnutCard;
import game.pvsz.models.plants.*;

public class PlantFactory {
    public static Plant createPlant (Card card, Line line) {
        if(card instanceof SunflowerCard) {
            return new Sunflower(line);
        } else if(card instanceof  PeaShooterCard) {
            return new PeaShooter(line);
        } else if (card instanceof SnowPeaCard) {
            return new SnowPea(line);
        } else if (card instanceof WalnutCard) {
            return new Walnut(line);
        } else if (card instanceof  CherryBombCard) {
            return new CherryBomb(line);
        } else {
            return  null;
        }
    }
}
