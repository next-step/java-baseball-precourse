package baseball;

import nextstep.utils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        List<Integer> answer = GameUtils.generateAnswer();
        Result result;
        do {
            String input = Console.readLine();
            result = GameUtils.match(answer, input);
        }while (result.isCorrect());

    }
}
