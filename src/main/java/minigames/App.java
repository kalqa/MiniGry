package minigames;

import minigames.lotto.LottoGame;
import minigames.lotto.LottoInputReceiver;
import minigames.lotto.LottoLogic;
import minigames.lotto.LottoPlayer;
import minigames.lotto.LottoRandomGenerator;
import minigames.model.GameResult;
import minigames.model.Player;

public class App {

    public static void main(String[] args) {
        final Player lottoPlayer = new LottoPlayer();
        final MessageGiver messageGiver = new MessageGiver();
        final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver(messageGiver);
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoLogic lottoLogic = new LottoLogic();
        final Game lottoGame = new LottoGame(lottoPlayer, messageGiver, lottoInputReceiver, randomGenerator, lottoLogic);
        final GameResult run = lottoGame.startGame();
    }
}
