package minigames.game;

import java.util.Set;

public interface MessageProvider {

    String getStartMessage(String gameName);
    String getWinnerMessage(String gameName, Set<Integer> hitNumbers);
    String getLoserMessage(String gameName);
    String getGiveNumberMessage();
    String getNotInRangeMessage();
    String getNotInRangeMessageWithGivenNumber();
}
