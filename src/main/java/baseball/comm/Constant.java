package baseball.comm;

import java.util.regex.Pattern;

public class Constant {
    public static final int NUM_SIZE = 3;
    public static final int GAME_END_STRIKE = 3;
    public static final Pattern IS_ONLY_NUMBER = Pattern.compile("^[0-9]*?");
    public static final String NUMBER_MESSAGE = "[ERROR] 숫자만 입력 가능 합니다." ;
    public static final String LENGTH_MESSAGE = "[ERROR] 3자리만 입력 가능 합니다.";
}

