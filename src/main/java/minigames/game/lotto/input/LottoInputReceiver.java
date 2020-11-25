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
    public static final int HOW_MANY_NUMBERS_FROM_USER = 6;

    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInput(scanner);
        scanner.close();
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbersFromUserInput(Scanner in) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.printf(LottoMessageProvider.PLEASE_GIVE_NUMBERS, HOW_MANY_NUMBERS_FROM_USER);
        while (areLessThanSixNumbersGiven(givenNumbers)) {
            while (!in.hasNextInt()) {
                System.out.printf(LottoMessageProvider.NOT_IN_RANGE, LOWER_BOUND, UPPER_BOUND);
                if (!in.hasNext()) {
                    return Collections.emptySet();
                }
                final String next = in.next();
                if (next.equalsIgnoreCase(QUIT_SIGN)) {
                    return Collections.emptySet();
                }
            }
            System.out.println(LottoMessageProvider.GIVE_NUMBER);
            final int userInput = in.nextInt();
            validateNumber(givenNumbers, userInput);
        }
        return givenNumbers;
    }

    private void validateNumber(Set<Integer> givenNumbers, int userInput) {
        if (isInRange(userInput)) {
            givenNumbers.add(userInput);
        } else {
            System.out.printf(LottoMessageProvider.NOT_IN_RANGE_WITH_GIVEN_NUMBER, userInput, LOWER_BOUND, UPPER_BOUND);
        }
    }

    private boolean areLessThanSixNumbersGiven(Set<Integer> numbers) {
        return numbers.size() < HOW_MANY_NUMBERS_FROM_USER;
    }

    private boolean isInRange(int givenNumber) {
        return givenNumber >= LOWER_BOUND && givenNumber <= UPPER_BOUND;
    }
}
