package game.pvsz.models.card;

import game.pvsz.views.CardBoard;

public class SunflowerCard extends Card{
    public SunflowerCard(CardBoard cardBoard) {
        super(cardBoard);
        this.score = 50;
        this.cooldownTime = 5;
        this.path = "/game/pvsz/images/card/card_sunflower.png";
    }
}
