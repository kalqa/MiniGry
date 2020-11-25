package minigames.game.lotto.input;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.game.lotto.messageprovider.LottoMessageProvider;

@AllArgsConstructor
public class LottoInputReceiver {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 99;
    private static final String QUIT_SIGN = "q";

    private final LottoMessageProvider lottoMessageProvider;

    public Set<Integer> getSixNumbers(Scanner in) {
        Set<Integer> givenNumbersFromUser = getNumbers(in);
        in.close();
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbers(Scanner in) {
        final Set<Integer> givenNumbers = new HashSet<>();
        while (areLessThanSixNumbersGiven(givenNumbers)) {
            while (!in.hasNextInt()) {
                System.out.printf(lottoMessageProvider.getNotInRangeMessage(), LOWER_BOUND, UPPER_BOUND);
                if (!in.hasNext()) {
                    return Collections.emptySet();
                }
                final String next = in.next();
                if (next.equalsIgnoreCase(QUIT_SIGN)) {
                    return Collections.emptySet();
                }
            }
            System.out.println(lottoMessageProvider.getGiveNumberMessage());
            final int userInput = in.nextInt();
            validateNumber(givenNumbers, userInput);
        }
        return givenNumbers;
    }

    private void validateNumber(Set<Integer> givenNumbers, int userInput) {
        if (isInRange(userInput)) {
            givenNumbers.add(userInput);
        } else {
            System.out.printf(lottoMessageProvider.getNotInRangeMessage(), userInput, LOWER_BOUND, UPPER_BOUND);
        }
    }

    private boolean areLessThanSixNumbersGiven(Set<Integer> numbers) {
        return numbers.size() < 6;
    }

    private boolean isInRange(int givenNumber) {
        return givenNumber >= LOWER_BOUND && givenNumber <= UPPER_BOUND;
    }
}
