package baseball;

import nextstep.utils.Console;

import java.util.List;

public class BaseballGame {

    boolean end;

    public void startGame(){
        List<Integer> answer = GameUtils.generateAnswer();
        Record record;
        do {
            System.out.println("입력해주세요 : ");
            String input = Console.readLine();
            record = GameUtils.match(answer, input);
        }while (record.isCorrect());
        askOfEndGame();
    }

    private void askOfEndGame() {
        System.out.println("정답을 맞추셨습니다. 새로운 게임을 진행하시려면 1번, 끝내시려면 2번을 눌러주세요");
        String input = Console.readLine();
        if("2".equals(input)) this.end = true;
    }

    public boolean isEnd() {
        return this.end;
    }
}
