package baseball;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = Console.readLine();
        baseBallGameManager.checkUserAnswer(userAnswer);
        System.out.println(userAnswer);
    }
}
