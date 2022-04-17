package baseball.model;

import baseball.BBCODE;

public interface BaseBallGameModel {
    String target = "";
    void setTarget();
    boolean isValidNumber(String input);
    int isBallCount(String input);
    int isStrikeCount(String input);

}
