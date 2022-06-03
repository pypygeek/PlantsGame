package game.pvsz.models.card;

import game.pvsz.views.CardBoard;

public class PeaShooterCard extends Card{
    public PeaShooterCard(CardBoard cardBoard) {
        super(cardBoard);
        this.score = 100;
        this.cooldownTime = 5;
        this.path = "/game/pvsz/images/card/card_peashooter.png";
    }
}
