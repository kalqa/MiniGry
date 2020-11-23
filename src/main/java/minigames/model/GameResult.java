package minigames.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GameResult {

    private String message;
    private Game game;
}
