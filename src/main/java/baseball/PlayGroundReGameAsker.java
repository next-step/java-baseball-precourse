package baseball;

import nextstep.utils.Console;

public class PlayGroundReGameAsker {
    private static final String WANT_REGAME_MSG = "1";
    private static final String DO_NOT_WANT_REGAME_MSG = "2";
    private static final String INPUT_REGAME_ERROR_MSG = "[ERROR] 1 또는 2를 입력해야 합니다. 다시 입력해 주세요...";

    public REGAME_FLAG getReGameAnswer() {
        REGAME_FLAG reGameFlag = REGAME_FLAG.NONE;

        while (reGameFlag == REGAME_FLAG.NONE) {
            reGameFlag = verifyReGameAnswer(Console.readLine());
        }

        return reGameFlag;
    }

    private REGAME_FLAG verifyReGameAnswer(String input) {
        if (input.equals(WANT_REGAME_MSG)) {
            return REGAME_FLAG.WANT;
        }

        if (input.equals(DO_NOT_WANT_REGAME_MSG)) {
            return REGAME_FLAG.NOT_WANT;
        }

        System.out.println(INPUT_REGAME_ERROR_MSG);

        return REGAME_FLAG.NONE;
    }
}
