package minigames.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.MessageGiver;

@AllArgsConstructor
public class LottoInputReceiver {

    private final MessageGiver messageGiver;

    public Set<Integer> getSixNumbers() {
        Scanner in = new Scanner(System.in);
        final Set<Integer> givenNumbers = new HashSet<Integer>();
        while (areLessThanSixNumbersGiven(givenNumbers)) {
            System.out.println(messageGiver.getGiveNumberMessage());
            givenNumbers.add(in.nextInt());
        }
        in.close();
        return givenNumbers;
    }

    private boolean areLessThanSixNumbersGiven(Set<Integer> numbers) {
        return numbers.size() < 6;
    }
}
