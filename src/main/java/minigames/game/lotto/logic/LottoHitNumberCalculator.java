package minigames.game.lotto.logic;

import java.util.HashSet;
import java.util.Set;

import minigames.game.lotto.model.LottoGameResultInfo;

public class LottoHitNumberCalculator {

    public LottoGameResultInfo getHitNumbers(Set<Integer> userGivenNumbers, Set<Integer> randomSixNumbers) {
        Set<Integer> finalHitNumbers = new HashSet<>(userGivenNumbers);
        finalHitNumbers.retainAll(randomSixNumbers);
        return new LottoGameResultInfo(userGivenNumbers, randomSixNumbers, finalHitNumbers);
    }
}
