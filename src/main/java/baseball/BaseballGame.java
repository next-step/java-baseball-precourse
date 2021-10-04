package baseball;

import nextstep.utils.Console;

import java.util.List;

public class BaseballGame {

    boolean end;

    public void startGame(){
        List<Integer> answer = GameUtils.generateAnswer();
        Record result;
        do {
            String input = Console.readLine();
            result = GameUtils.match(answer, input);
        }while (result.isCorrect());
    }

    public boolean isEnd() {
        return this.end;
    }
}
