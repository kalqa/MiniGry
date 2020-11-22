package minigames;

import minigames.lotto.LottoGame;
import minigames.model.GameResult;
import minigames.lotto.LottoPlayer;
import minigames.model.Player;

public class App {

    public static void main(String[] args) {
        final Player lottoPlayer = new LottoPlayer();
        final MessageGiver messageGiver = new MessageGiver();
        final Game lottoGame = new LottoGame(lottoPlayer,messageGiver );
        final GameResult run = lottoGame.startGame();
    }
}
