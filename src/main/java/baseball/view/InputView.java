package baseball.view;

import baseball.model.AnswerNumbers;
import nextstep.utils.Console;

public class InputView {

    public static AnswerNumbers askAnswer(){
        System.out.print("숫자를 입력해주세요 : ");
        try{
            return new AnswerNumbers(Console.readLine());
        }catch(IllegalArgumentException e ) {
            System.out.println(e.getMessage());
            return askAnswer();
        }
    }

    public static String askRegame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static void askRegameErrorMessage() {
        System.out.println("[ERROR] 사용자의 입력이 1과 2의 범위를 벗어납니다.");
    }
}
