package baseball.view;

import baseball.BBCODE;
import baseball.COMMAND;

import java.util.List;

public class BaseBallGameViewImpl implements BaseBallGameView{
    @Override
    public void printCodeText(BBCODE code) {
        System.out.println(code.text);
    }

    @Override
    public void reqNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void continueGame() {
        StringBuilder infoText = new StringBuilder();
        infoText.append("게임을 새로 시작하려면 ")
                .append(COMMAND.CONTINUE.code)
                .append(", 종료하려면 ")
                .append(COMMAND.END.code)
                .append("를 입력하세요.");
        System.out.println(infoText);
    }
}
