package minigames.game.lotto;

import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.game.Game;
import minigames.MessageProvider;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoLogic;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.model.GameResult;
import minigames.model.Player;

@AllArgsConstructor
public class LottoGame implements Game {

    public static final String GAME_NAME = "Lotto";

    private final Player player;
    private final MessageProvider messageProvider;
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
            return getGameResult(messageProvider.getLoserMessage(GAME_NAME));
        }
        return getGameResult(messageProvider.getWinnerMessage(GAME_NAME, hitNumbers));
    }

    private GameResult getGameResult(String gameResultMessage) {
        return new GameResult(gameResultMessage, this, player);
    }
}
