package baseball;

import nextstep.utils.Console;

import java.util.List;

public class BaseballGame {

    boolean end;

    public BaseballGame() {
        this.end = false;
    }

    public void startGame(){
        List<Integer> answer = GameUtils.generateAnswer();
        System.out.println(answer);
        Record record;
        do {
            System.out.println("입력해주세요 : ");
            String input = Console.readLine();
            record = GameUtils.match(answer, input);
        }while (!record.isCorrect());
        askOfEndGame();
    }

    private void askOfEndGame() {
        System.out.println("정답을 맞추셨습니다. 새로운 게임을 진행하시려면 1번, 끝내시려면 2번을 눌러주세요");
        String input = Console.readLine();
        if ("2".equals(input)) {
            exitGame();
        }
    }

    private void exitGame() {
        this.end = true;
    }

    public boolean isEnd() {
        System.out.println("end = " + end);
        return this.end;
    }
}
