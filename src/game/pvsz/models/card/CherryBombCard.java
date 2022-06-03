package game.pvsz.models.card;

import game.pvsz.views.CardBoard;

public class CherryBombCard extends Card{
    public CherryBombCard(CardBoard cardBoard) {
        super(cardBoard);
        this.score = 150;
        this.cooldownTime = 60;
        this.path = "/game/pvsz/images/card/card_cherrybomb.png";
    }
}
