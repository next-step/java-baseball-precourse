package baseball.view;

import baseball.enums.MessageEnum;
import nextstep.utils.Console;

public class UserInputView extends PrintView{

    public String receiveUserInput() {
        super.printMessage(MessageEnum.INPUT_TEXT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String receiveUserRestart() {
        super.printMessage(MessageEnum.GAME_OVER_MESSAGE.getMessage());
        return Console.readLine();
    }

}
