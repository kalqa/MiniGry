package minigames.game.lotto.input;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.MessageProvider;

@AllArgsConstructor
public class LottoInputReceiver {

    private final MessageProvider messageProvider;

    public Set<Integer> getSixNumbers() {
        Scanner in = new Scanner(System.in);
        final Set<Integer> givenNumbers = new HashSet<Integer>();
        while (areLessThanSixNumbersGiven(givenNumbers)) {
            System.out.println(messageProvider.getGiveNumberMessage());
            givenNumbers.add(in.nextInt());
        }
        in.close();
        return givenNumbers;
    }

    private boolean areLessThanSixNumbersGiven(Set<Integer> numbers) {
        return numbers.size() < 6;
    }
}
