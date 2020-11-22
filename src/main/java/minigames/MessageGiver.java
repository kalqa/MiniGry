package minigames;

public class MessageGiver {

    public static final String GAME_S_STARTED = "Game: %s started";
    public static final String YOU_WON_S_GAME = "You won: %s game";
    public static final String YOU_LOST_S_GAME = "You lost: %s game";

    public String getStartMessage(String gameName) {
        return String.format(GAME_S_STARTED, gameName);
    }

    public String getWinnerMessage(String gameName) {
        return String.format(YOU_WON_S_GAME, gameName);
    }

    public String getLoserMessage(String gameName) {
        return String.format(YOU_LOST_S_GAME, gameName);
    }
}
