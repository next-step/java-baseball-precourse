package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Game {

    public static final String GAME_RESTART = "1";
    public static final String GAME_OVER = "2";

    public static final String MESSAGE_INFO_INPUT = "숫자를 입력해주세요: ";
    public static final String MESSAGE_INFO_SELECT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MESSAGE_INFO_GAME_OVER = "게임 종료";
    public static final String MESSAGE_ERROR_INPUT = "입력이 올바르지 않습니다.";

    public static final int ANSWER_SIZE = 3;
    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 9;

    public void play() {
        start();
    }

    private void start() {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();

        while(answer.size() < ANSWER_SIZE) {
            answer.add(Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX));

        }
        progress(answer);
    }

    private void progress(LinkedHashSet<Integer> answer) {
        System.out.print(MESSAGE_INFO_INPUT);
        String input = Console.readLine();
        System.out.println(input);

        Umpire umpire = new Umpire();
        umpire.validate(input);

        if (umpire.getHint(answer, input)) {
            end();
            return;
        }

        progress(answer);
    }

    private void end() {
        System.out.println(MESSAGE_INFO_SELECT);

        String input = Console.readLine().trim();

        if(!input.equals(GAME_RESTART) && !input.equals(GAME_OVER)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT);
        }

        if(input.equals(GAME_RESTART)) {
            start();
        }
        if(input.equals(GAME_OVER)) {
            System.out.println(MESSAGE_INFO_GAME_OVER);
        }
    }
}
