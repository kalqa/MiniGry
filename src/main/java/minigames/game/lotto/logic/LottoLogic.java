package minigames.game.lotto.logic;

import java.util.HashSet;
import java.util.Set;

public class LottoLogic {

    public Set<Integer> getHitNumbers(Set<Integer> sixNumbers, Set<Integer> randomSixNumbers) {
        Set<Integer> finalHitNumbers = new HashSet<>(sixNumbers);
        finalHitNumbers.retainAll(randomSixNumbers);
        return finalHitNumbers;
    }
}
