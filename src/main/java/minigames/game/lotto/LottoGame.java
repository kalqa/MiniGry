package minigames.game.lotto;

import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.MessageProvider;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoLogic;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.model.Game;
import minigames.model.GameResult;

@AllArgsConstructor
public class LottoGame implements Game {

    public static final String GAME_NAME = "Lotto";

    private final MessageProvider messageProvider;
    private final LottoInputReceiver lottoInputReceiver;
    private final LottoRandomGenerator randomGenerator;
    private final LottoLogic lottoLogic;

    public GameResult startGame() {
        final Set<Integer> hitNumbers = getHitNumbers();
        return getGameResult(hitNumbers);
    }

    private Set<Integer> getHitNumbers() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers();
        final Set<Integer> randomNumbers = randomGenerator.getSixNumbers();
        return lottoLogic.getHitNumbers(inputNumbers, randomNumbers);
    }

    private GameResult getGameResult(Set<Integer> hitNumbers) {
        if (isZeroHits(hitNumbers)) {
            return getGameResult(messageProvider.getLoserMessage(GAME_NAME));
        }
        return getGameResult(messageProvider.getWinnerMessage(GAME_NAME, hitNumbers));
    }

    private boolean isZeroHits(Set<Integer> hitNumbers) {
        return hitNumbers.isEmpty();
    }

    private GameResult getGameResult(String gameResultMessage) {
        return new GameResult(gameResultMessage, this);
    }
}
