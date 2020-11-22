package minigames.lotto;

import minigames.Game;
import minigames.MessageGiver;
import minigames.model.GameResult;
import minigames.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGameTest {

    private final Player player = new LottoPlayer();
    private final MessageGiver messageGiver = new MessageGiver();
    private final Game game = new LottoGame(player, messageGiver);

    @Test
    public void shouldReturnWinnerMessageWhenPlayerIsWinner() {
        // given
        player.setAsWinner(true);
        // when
        final GameResult run = game.startGame();
        // then
        assertEquals("You won: Lotto game", run.message);
    }

    @Test
    public void shouldReturnLoserMessageWhenPlayerIsLoser() {
        // given
        player.setAsWinner(false);
        // when
        final GameResult run = game.startGame();
        // then
        assertEquals("You lost: Lotto game", run.message);
    }
}