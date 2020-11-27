package minigames.game.lotto.input;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoInputReceiverTest {

    LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

    @Test
    public void shouldReturnNumbersInSetWhenAllInRange() {
        // given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        String givenNumbers = "1 2 3 4 5 6";
        Scanner scanner = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        // then
        assertEquals(expectedNumbers, userInputNumbers);
    }

    @Test
    public void shouldReturnNumbersInSetWhenOneNotInRange() {
        // given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 15)));
        String givenNumbers = "1 2 3 4 5 101 15";
        Scanner scanner = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        // then
        assertEquals(expectedNumbers, userInputNumbers);
    }

    @Test
    public void shouldReturnZeroNumbersInSetWhenAllNotInRange() {
        // given
        Set<Integer> expectedNumbers = Collections.emptySet();
        String givenNumbers = "101 102 103 103 104 105 106";
        Scanner scanner = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        // then
        assertEquals(expectedNumbers, userInputNumbers);
    }

    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}