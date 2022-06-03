package game.pvsz.models.card;

import game.pvsz.views.CardBoard;

public class SnowPeaCard extends Card{
    public SnowPeaCard(CardBoard cardBoard) {
        super(cardBoard);
        this.score = 170;
        this.cooldownTime = 5;
        this.path = "/game/pvsz/images/card/card_freezepeashooter.png";
    }
}
