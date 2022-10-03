package baseball.view;

import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public Player printInputView(){
        System.out.print("숫자를 입력해주세요 : ");
        return new Player(Console.readLine());
    }
}
