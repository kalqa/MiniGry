package minigames.game.lotto.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minigames.game.lotto.messageprovider.LottoMessageProvider;
import minigames.model.GameResultInfo;

@AllArgsConstructor
@Getter
public class LottoGameResultInfo implements GameResultInfo {

    private final Set<Integer> userGivenNumbers;
    private final Set<Integer> randomSixNumbers;
    private final Set<Integer> finalHitNumbers;

    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessageProvider.LOTTO_RESULT_MESSAGE, finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }
}
