package minigames.game.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import minigames.game.Game;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoHitNumberCalculator;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.model.GameResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameTest {

    private static final Scanner scannerMock = new Scanner(System.in);
    private static final LottoHitNumberCalculator LOTTO_HIT_NUMBER_GENERATOR = new LottoHitNumberCalculator();

    private static LottoInputReceiver lottoInputReceiverMock;
    private static LottoRandomGenerator randomGeneratorMock;

    @BeforeAll
    public static void beforeEach() {
        lottoInputReceiverMock = mock(LottoInputReceiver.class);
        randomGeneratorMock = mock(LottoRandomGenerator.class);
    }

    @Test
    public void shouldReturnWinnerMessageWhenPlayerIsWinner() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoInputReceiverMock, randomGeneratorMock, LOTTO_HIT_NUMBER_GENERATOR, scannerMock);
        // when
        final GameResult gameResult = lottoGame.startGame();
        // then
        assertEquals("You hit 6 numbers! Winning numbers were [1, 2, 3, 4, 5, 6], and yours were [1, 2, 3, 4, 5, 6]", gameResult.getGameResultInfo().getGameResultMessage());
    }

    @Test
    public void shouldReturnLoserMessageWhenPlayerIsLoser() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoInputReceiverMock, randomGeneratorMock, LOTTO_HIT_NUMBER_GENERATOR, scannerMock);
        // when
        final GameResult gameResult = lottoGame.startGame();
        // then
        assertEquals("You hit 0 numbers! Winning numbers were [7, 8, 9, 10, 11, 12], and yours were [1, 2, 3, 4, 5, 6]", gameResult.getGameResultInfo().getGameResultMessage());
    }

    @Test
    public void shouldReturnWinnerWithOneNumberMessageWhenPlayerHitOneNumber() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(6, 8, 9, 10, 11, 12)));
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoInputReceiverMock, randomGeneratorMock, LOTTO_HIT_NUMBER_GENERATOR, scannerMock);
        // when
        final GameResult gameResult = lottoGame.startGame();
        // then
        assertEquals("You hit 1 numbers! Winning numbers were [6, 8, 9, 10, 11, 12], and yours were [1, 2, 3, 4, 5, 6]", gameResult.getGameResultInfo().getGameResultMessage());
    }

    private void mockNumbers(Set<Integer> playerGivenNumbers, Set<Integer> randomNumbers) {
        when(lottoInputReceiverMock.getSixNumbers(scannerMock)).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getRandomSixNumbers()).thenReturn(randomNumbers);
    }
}