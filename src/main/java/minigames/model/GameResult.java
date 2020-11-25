package minigames.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import minigames.game.Game;

@AllArgsConstructor
@Data
public class GameResult {

    private String message;
    private Game game;
}
