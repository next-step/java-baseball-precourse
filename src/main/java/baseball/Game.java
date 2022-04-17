package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Game {
    public void play() {
        start();
    }

    private void start() {
        System.out.println("게임 시작");

        // 정답 생성(서로 다른 임의의 수 3개 선택)
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();

        while(answer.size() < 3) {
            answer.add(Randoms.pickNumberInRange(1, 9));
        }
        System.out.println(answer);

        progress(answer);
    }

    private void progress(LinkedHashSet<Integer> answer) {
        System.out.println("게임 진행");

        // 게임 진행
        System.out.print("숫자를 입력해주세요: ");
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
        System.out.println("게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine().trim();

        if(!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        if(input.equals("1")) {
            start();
        }
    }
}
