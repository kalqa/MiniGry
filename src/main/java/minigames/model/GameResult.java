package minigames.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minigames.game.Game;

@AllArgsConstructor
@Getter
public class GameResult {

    private final Game game;
    private final GameResultInfo gameResultInfo;
}
