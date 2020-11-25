package minigames.game.lotto.messageprovider;

import java.util.Set;

import minigames.game.MessageProvider;

public class LottoMessageProvider implements MessageProvider {

    private static final String GAME_S_STARTED = "Game: %s started";
    private static final String YOU_WON_S_GAME = "You won: %s game, your hit numbers: %s";
    private static final String YOU_LOST_S_GAME = "You lost: %s game";
    private static final String GIVE_NUMBER = "Please give number";
    private static final String NOT_IN_RANGE = "Incorrect input please give number in range %d-%d inclusive";
    private static final String NOT_IN_RANGE_WITH_GIVEN_NUMBER = "Given number: %d must be in range %d-%d";

    public String getStartMessage(String gameName) {
        return String.format(GAME_S_STARTED, gameName);
    }

    public String getWinnerMessage(String gameName, Set<Integer> hitNumbers) {
        return String.format(YOU_WON_S_GAME, gameName, hitNumbers);
    }

    public String getLoserMessage(String gameName) {
        return String.format(YOU_LOST_S_GAME, gameName);
    }

    public String getGiveNumberMessage() {
        return GIVE_NUMBER;
    }

    public String getNotInRangeMessageWithGivenNumber() {
        return NOT_IN_RANGE_WITH_GIVEN_NUMBER;
    }

    public String getNotInRangeMessage() {
        return NOT_IN_RANGE;
    }
}
