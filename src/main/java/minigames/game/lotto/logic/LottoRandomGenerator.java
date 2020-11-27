package minigames.game.lotto.logic;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

import static minigames.game.lotto.config.LottoGameConfiguration.NUMBERS_TO_GENERATE;
import static minigames.game.lotto.config.LottoGameConfiguration.NUMBER_ORIGIN;
import static minigames.game.lotto.config.LottoGameConfiguration.RANDOM_NUMBER_BOUND;

public class LottoRandomGenerator {

    public Set<Integer> getRandomSixNumbers() {
        SecureRandom random = new SecureRandom();
        return random.ints(NUMBERS_TO_GENERATE, NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
                .boxed()
                .collect(Collectors.toSet());
    }
}
