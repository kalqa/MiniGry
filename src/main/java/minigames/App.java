package minigames;

import minigames.game.Game;
import minigames.game.lotto.LottoGame;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoLogic;
import minigames.game.lotto.player.LottoPlayer;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.model.GameResult;
import minigames.model.Player;

public class App {

    public static void main(String[] args) {
        final Player lottoPlayer = new LottoPlayer();
        final MessageProvider messageProvider = new MessageProvider();
        final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver(messageProvider);
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoLogic lottoLogic = new LottoLogic();
        final Game lottoGame = new LottoGame(lottoPlayer, messageProvider, lottoInputReceiver, randomGenerator, lottoLogic);
        final GameResult run = lottoGame.startGame();
    }
}
