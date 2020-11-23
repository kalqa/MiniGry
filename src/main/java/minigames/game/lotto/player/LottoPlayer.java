package minigames.game.lotto.player;

import lombok.Setter;
import minigames.model.Player;

@Setter
public class LottoPlayer implements Player {

    private boolean isWinner;

    public boolean isWinner() {
        return isWinner;
    }

    public void setAsWinner(boolean winner) {
        isWinner = winner;
    }
}
