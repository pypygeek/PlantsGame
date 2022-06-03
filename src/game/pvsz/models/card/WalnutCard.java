package game.pvsz.models.card;

import game.pvsz.views.CardBoard;

public class WalnutCard extends Card{
    public WalnutCard(CardBoard cardBoard) {
        super(cardBoard);
        this.score = 50;
        this.cooldownTime = 30;
        this.path = "/game/pvsz/images/card/card_wallnut.png";
    }
}
