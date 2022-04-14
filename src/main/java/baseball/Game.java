package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Game {
    public void play() {
        start();
        progress();
        end();
    }

    private void start() {
        System.out.println("게임 시작");

        // 정답 생성(서로 다른 임의의 수 3개 선택)
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();

        while(answer.size() < 3) {
            answer.add(Randoms.pickNumberInRange(1, 9));
        }
        System.out.println(answer);
    }

    private void progress() {
        System.out.println("게임 진행");
    }

    private void end() {
        System.out.println("게임 종료");
    }
}
