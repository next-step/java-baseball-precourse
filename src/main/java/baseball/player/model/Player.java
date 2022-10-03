package baseball.player.model;

import baseball.game.model.GameNumber;
import baseball.player.model.Number;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Player {
    public Set<Integer> number;
    public boolean isAnswer;
    public boolean keepPlaying;

    public Player() {
        this.keepPlaying = true;
    }



    public void playGame() {
        GameNumber gameNumbers = new GameNumber();
        System.out.println(gameNumbers.answer);

        while(!isAnswer) {
            enterNumber();
            if (compare(gameNumbers.answer)) {
                break;
            }
        }
    }

    public void enterNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String text = Console.readLine();
        Number number = new Number();
        number.validateNumber(text);
        this.number = number.parsingNumber(text);
    }

    public boolean compare(List<Integer> answer) {
        if (Arrays.equals(answer.toArray(), this.number.toArray())) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
