package baseball.view;

import baseball.utils.Utils;
import baseball.domain.Validator;
import nextstep.utils.Console;

import java.util.List;

public class ViewConsole {

    public List<Integer> enterNumber() {
        String input;
        do {
            input = enterInput("숫자를 입력해주세요 : ");
        } while (!confirmInput(input));
        return Utils.convertIntegerArray(input);
    }

    private static boolean confirmInput(String input) {
        try {
            Validator.validateEnterNumber(input);
            return true;
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
            return false;
        }
    }

    public boolean askOfFinishGame() {
        String input = enterInput("3개의 숫자를 모두 맞히셨습니다! 게임 끝.\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (!("1".equals(input) || "2".equals(input))) {
            input = enterInput("잘못입력하셨습니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return "2".equals(input);
    }

    private static String enterInput(String explainText) {
        System.out.println(explainText);
        return Console.readLine();
    }

    public void printOutput(String outputText){
        System.out.println(outputText);
    }
}
