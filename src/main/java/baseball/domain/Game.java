package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class Game {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int ANSWER_SIZE = 3;
    public static final String MSG_INPUT = "숫자를 입력해주세요: ";

    public LinkedHashSet<Integer> generateAnswer() {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();
        while (answer.size() < ANSWER_SIZE) {
            answer.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return answer;
    }

    public void play() {
        LinkedHashSet<Integer> answer = generateAnswer();

        System.out.print(MSG_INPUT);
        String input = Console.readLine();

        LinkedHashSet<Integer> player = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            player.add(Integer.parseInt(input.substring(i, i + 1)));
        }

        Umpire umpire = new Umpire();
        umpire.judge(answer, player);
    }

}
