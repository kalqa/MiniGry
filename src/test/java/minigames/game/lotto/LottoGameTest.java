package minigames.game.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import minigames.game.Game;
import minigames.MessageProvider;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoLogic;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.game.lotto.player.LottoPlayer;
import minigames.model.GameResult;
import minigames.model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LottoGameTest {

    private final Player player = new LottoPlayer();
    private final MessageProvider messageProvider = new MessageProvider();
    private final LottoLogic lottoLogic = new LottoLogic();
    private static LottoInputReceiver lottoInputReceiverMock;
    private static LottoRandomGenerator randomGeneratorMock;
//    private final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver(messageGiver);
//    private final Game game = new LottoGame(player, messageGiver, lottoInputReceiver);

    @BeforeAll
    public static void beforeEach() {
        lottoInputReceiverMock = Mockito.mock(LottoInputReceiver.class);
        randomGeneratorMock = Mockito.mock(LottoRandomGenerator.class);
    }

    @Test
    public void shouldReturnWinnerMessageWhenPlayerIsWinner() {
        // given
        Game game = new LottoGame(player, messageProvider, lottoInputReceiverMock, randomGeneratorMock, lottoLogic);
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        when(lottoInputReceiverMock.getSixNumbers()).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getSixNumbers()).thenReturn(randomNumbers);
        // when
        final GameResult gameResult = game.startGame();
        // then
        assertEquals("You won: Lotto game, your hit numbers: [1, 2, 3, 4, 5, 6]", gameResult.message);
    }

    @Test
    public void shouldReturnLoserMessageWhenPlayerIsLoser() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        when(lottoInputReceiverMock.getSixNumbers()).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getSixNumbers()).thenReturn(randomNumbers);
        Game game = new LottoGame(player, messageProvider, lottoInputReceiverMock, randomGeneratorMock, lottoLogic);
        // when
        final GameResult gameResult = game.startGame();
        // then
        assertEquals("You lost: Lotto game", gameResult.message);
    }

    @Test
    public void shouldReturnWinnerWithOneNumberMessageWhenPlayerHitOneNumber() {
        // given
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(6, 8, 9, 10, 11, 12)));
        when(lottoInputReceiverMock.getSixNumbers()).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getSixNumbers()).thenReturn(randomNumbers);
        Game game = new LottoGame(player, messageProvider, lottoInputReceiverMock, randomGeneratorMock, lottoLogic);
        // when
        final GameResult gameResult = game.startGame();
        // then
        assertEquals("You won: Lotto game, your hit numbers: [6]", gameResult.message);
    }
}