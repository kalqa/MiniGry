package minigames;

import java.util.Scanner;

import minigames.game.Game;
import minigames.game.lotto.LottoGame;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoLogic;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.game.lotto.messageprovider.LottoMessageProvider;
import minigames.model.GameResult;

public class App {

    public static void main(String[] args) {
        final LottoMessageProvider lottoMessageProvider = new LottoMessageProvider();
        final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver(lottoMessageProvider);
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoLogic lottoLogic = new LottoLogic();
        final Scanner scanner = new Scanner(System.in);
        final Game lottoGame = new LottoGame(lottoMessageProvider, lottoInputReceiver, randomGenerator, lottoLogic, scanner);
        final GameResult run = lottoGame.startGame();
    }
}
