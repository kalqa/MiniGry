package minigames.model;

import lombok.AllArgsConstructor;
import minigames.game.Game;

@AllArgsConstructor
public class GameResult {

    public String message;
    public Game game;
    public Player winner;
}
