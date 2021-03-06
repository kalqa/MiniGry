package minigames;

import java.util.Scanner;

import minigames.game.Game;
import minigames.game.lotto.LottoGame;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoHitNumberCalculator;
import minigames.game.lotto.logic.LottoRandomGenerator;

public class App {

    public static void main(String[] args) {
        final Game lottoGame = getLottoGame();
        lottoGame.startGame();
    }

    private static Game getLottoGame() {
        final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoHitNumberCalculator lottoHitNumberCalculator = new LottoHitNumberCalculator();
        final Scanner scanner = new Scanner(System.in);
        return new LottoGame(lottoInputReceiver, randomGenerator, lottoHitNumberCalculator, scanner);
    }
}
