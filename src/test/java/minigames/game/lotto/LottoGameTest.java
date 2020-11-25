package minigames.game.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import minigames.game.Game;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoLogic;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.game.lotto.messageprovider.LottoMessageProvider;
import minigames.model.GameResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameTest {

    public static final Scanner scannerMock = new Scanner(System.in);
    private final LottoMessageProvider lottoMessageProvider = new LottoMessageProvider();
    private final LottoLogic lottoLogic = new LottoLogic();
    private static LottoInputReceiver lottoInputReceiverMock;
    private static LottoRandomGenerator randomGeneratorMock;
//    private final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver(messageGiver);
//    private final Game game = new LottoGame(player, messageGiver, lottoInputReceiver);

    @BeforeAll
    public static void beforeEach() {
        lottoInputReceiverMock = mock(LottoInputReceiver.class);
        randomGeneratorMock = mock(LottoRandomGenerator.class);
    }

    @Test
    public void shouldReturnWinnerMessageWhenPlayerIsWinner() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoMessageProvider, lottoInputReceiverMock, randomGeneratorMock, lottoLogic, scannerMock);
        // when
        final GameResult gameResult = lottoGame.startGame();
        // then
        assertEquals("You won: Lotto game, your hit numbers: [1, 2, 3, 4, 5, 6]", gameResult.getMessage());
    }

    @Test
    public void shouldReturnLoserMessageWhenPlayerIsLoser() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoMessageProvider, lottoInputReceiverMock, randomGeneratorMock, lottoLogic, scannerMock);
        // when
        final GameResult gameResult = lottoGame.startGame();
        // then
        assertEquals("You lost: Lotto game", gameResult.getMessage());
    }

    @Test
    public void shouldReturnWinnerWithOneNumberMessageWhenPlayerHitOneNumber() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(6, 8, 9, 10, 11, 12)));
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoMessageProvider, lottoInputReceiverMock, randomGeneratorMock, lottoLogic, scannerMock);
        // when
        final GameResult gameResult = lottoGame.startGame();
        // then
        assertEquals("You won: Lotto game, your hit numbers: [6]", gameResult.getMessage());
    }

    private void mockNumbers(Set<Integer> playerGivenNumbers, Set<Integer> randomNumbers) {
        when(lottoInputReceiverMock.getSixNumbers(scannerMock)).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getSixNumbers()).thenReturn(randomNumbers);
    }
}