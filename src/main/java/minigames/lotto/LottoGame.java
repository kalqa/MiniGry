package minigames.lotto;

import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.Game;
import minigames.MessageGiver;
import minigames.model.GameResult;
import minigames.model.Player;

@AllArgsConstructor
public class LottoGame implements Game {

    public static final String GAME_NAME = "Lotto";

    private final Player player;
    private final MessageGiver messageGiver;
    private final LottoInputReceiver lottoInputReceiver;

    public GameResult startGame() {
        final Set<String> sixNumbers = lottoInputReceiver.getSixNumbers();

        return getGameResult();
    }

    private GameResult getGameResult() {
        if (player.isWinner()) {
            return getGameResult(messageGiver.getWinnerMessage(GAME_NAME));
        }
        return getGameResult(messageGiver.getLoserMessage(GAME_NAME));
    }

    private GameResult getGameResult(String gameResultMessage) {
        return new GameResult(gameResultMessage, this, player);
    }
}
