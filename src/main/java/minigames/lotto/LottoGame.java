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
    private final LottoRandomGenerator randomGenerator;
    private final LottoLogic lottoLogic;

    public GameResult startGame() {
        final Set<Integer> sixNumbers = lottoInputReceiver.getSixNumbers();
        final Set<Integer> randomSixNumbers = randomGenerator.getSixNumbers();
        final Set<Integer> hitNumbers = lottoLogic.getHitNumbers(sixNumbers, randomSixNumbers);
        return getGameResult(hitNumbers);
    }

    private GameResult getGameResult(Set<Integer> hitNumbers) {
        if (hitNumbers.isEmpty()) {
            return getGameResult(messageGiver.getLoserMessage(GAME_NAME));
        }
        return getGameResult(messageGiver.getWinnerMessage(GAME_NAME, hitNumbers));
    }

    private GameResult getGameResult(String gameResultMessage) {
        return new GameResult(gameResultMessage, this, player);
    }
}
