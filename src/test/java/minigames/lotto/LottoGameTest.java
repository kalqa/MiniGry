package minigames.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import minigames.Game;
import minigames.MessageGiver;
import minigames.model.GameResult;
import minigames.model.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LottoGameTest {

    private final Player player = new LottoPlayer();
    private final MessageGiver messageGiver = new MessageGiver();
    private final LottoLogic lottoLogic = new LottoLogic();

//    private final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver(messageGiver);
//    private final Game game = new LottoGame(player, messageGiver, lottoInputReceiver);

    @Test
    public void shouldReturnWinnerMessageWhenPlayerIsWinner() {
        // given
        LottoInputReceiver lottoInputReceiverMock = Mockito.mock(LottoInputReceiver.class);
        LottoRandomGenerator randomGeneratorMock = Mockito.mock(LottoRandomGenerator.class);
        Game game = new LottoGame(player, messageGiver, lottoInputReceiverMock, randomGeneratorMock, lottoLogic);
        player.setAsWinner(true);
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        when(lottoInputReceiverMock.getSixNumbers()).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getSixNumbers()).thenReturn(randomNumbers);
        // when
        final GameResult run = game.startGame();
        // then
        assertEquals("You won: Lotto game, your hit numbers: [1, 2, 3, 4, 5, 6]", run.message);
    }

    @Test
    public void shouldReturnLoserMessageWhenPlayerIsLoser() {
        // given
        LottoInputReceiver lottoInputReceiverMock = Mockito.mock(LottoInputReceiver.class);
        LottoRandomGenerator randomGeneratorMock = Mockito.mock(LottoRandomGenerator.class);
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        when(lottoInputReceiverMock.getSixNumbers()).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getSixNumbers()).thenReturn(randomNumbers);
        Game game = new LottoGame(player, messageGiver, lottoInputReceiverMock, randomGeneratorMock, lottoLogic);
        player.setAsWinner(false);
        // when
        final GameResult run = game.startGame();
        // then
        assertEquals("You lost: Lotto game", run.message);
    }

    @Test
    public void shouldReturnWinnerWithOneNumberMessageWhenPlayerHitOneNumber() {
        // given
        LottoInputReceiver lottoInputReceiverMock = Mockito.mock(LottoInputReceiver.class);
        LottoRandomGenerator randomGeneratorMock = Mockito.mock(LottoRandomGenerator.class);
        Set<Integer> playerGivenNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(6, 8, 9, 10, 11, 12)));
        when(lottoInputReceiverMock.getSixNumbers()).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getSixNumbers()).thenReturn(randomNumbers);
        Game game = new LottoGame(player, messageGiver, lottoInputReceiverMock, randomGeneratorMock, lottoLogic);
        player.setAsWinner(false);
        // when
        final GameResult run = game.startGame();
        // then
        assertEquals("You won: Lotto game, your hit numbers: [6]", run.message);
    }
}