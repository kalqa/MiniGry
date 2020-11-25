package minigames.game.lotto;

import java.util.Scanner;
import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.game.Game;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoLogic;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.game.lotto.messageprovider.LottoMessageProvider;
import minigames.model.GameResult;

@AllArgsConstructor
public class LottoGame implements Game {

    public static final String GAME_NAME = "Lotto";

    private final LottoMessageProvider lottoMessageProvider;
    private final LottoInputReceiver lottoInputReceiver;
    private final LottoRandomGenerator randomGenerator;
    private final LottoLogic lottoLogic;
    private final Scanner scanner;

    public GameResult startGame() {
        final Set<Integer> hitNumbers = getHitNumbers();
        return getGameResult(hitNumbers);
    }

    private Set<Integer> getHitNumbers() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        final Set<Integer> randomNumbers = randomGenerator.getRandomSixNumbers();
        return lottoLogic.getHitNumbers(inputNumbers, randomNumbers);
    }

    private GameResult getGameResult(Set<Integer> hitNumbers) {
        if (isZeroHits(hitNumbers)) {
            return getGameResult(lottoMessageProvider.getLoserMessage(GAME_NAME));
        }
        return getGameResult(lottoMessageProvider.getWinnerMessage(GAME_NAME, hitNumbers));
    }

    private boolean isZeroHits(Set<Integer> hitNumbers) {
        return hitNumbers.isEmpty();
    }

    private GameResult getGameResult(String gameResultMessage) {
        return new GameResult(gameResultMessage, this);
    }
}
