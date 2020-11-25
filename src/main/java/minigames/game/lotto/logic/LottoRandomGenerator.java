package minigames.game.lotto.logic;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoRandomGenerator {

    private static final int NUMBERS_TO_GENERATE = 6;
    private static final int NUMBER_ORIGIN = 1;
    private static final int RANDOM_NUMBER_BOUND = 100;

    public Set<Integer> getRandomSixNumbers() {
        SecureRandom random = new SecureRandom();
        return random.ints(NUMBERS_TO_GENERATE, NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
                .boxed()
                .collect(Collectors.toSet());
    }
}
