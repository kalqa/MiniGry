package minigames.lotto;

import lombok.AllArgsConstructor;
import minigames.Game;
import minigames.MessageGiver;
import minigames.model.GameResult;
import minigames.model.Player;

@AllArgsConstructor
public class LottoGame implements Game {

    public static final String GAME_NAME = "Lotto";

    Player player;
    MessageGiver messageGiver;

    public GameResult startGame() {

        return getGameResult();
    }

    public boolean isWinner() {
        return player.isWinner();
    }

    private GameResult getGameResult() {
        if (player.isWinner()) {
            return createGameResult(messageGiver.getWinnerMessage(GAME_NAME));
        }
        return createGameResult(messageGiver.getLoserMessage(GAME_NAME));
    }

    private GameResult createGameResult(String gameResultMessage) {
        return new GameResult(gameResultMessage, this, player);
    }
}
