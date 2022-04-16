package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.LinkedList;

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

        if(input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자만 입력가능합니다.");
        }

        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        for(int i = 0; i < input.length(); i++) {
            int tempValue = input.charAt(i) - '0';
            if(tempValue < 1 || tempValue > 9) {
                throw new IllegalArgumentException("숫자(1~9)가 아닌 문자가 입력되었습니다.");
            }

            temp.add(tempValue);
        }

        if(temp.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }

        int strikeCount = 0;
        int ballCount = 0;

        LinkedList<Integer> targetNumber = new LinkedList<>(answer);
        System.out.println(targetNumber);

        LinkedList<Integer> inputNumber = new LinkedList<>();
        for(int i = 0; i < input.length(); i++) {
            inputNumber.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        System.out.println(inputNumber);

        for(int i = 0; i < input.length(); i++) {
            if(targetNumber.contains(inputNumber.get(i))) {
                if(targetNumber.get(i) == inputNumber.get(i)) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }

        if(strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            end();
            return;
        }

        String hint_strike = (strikeCount == 0) ? "" : (strikeCount + "스트라이크 ");
        String hint_ball = (ballCount == 0) ? "" : (ballCount + "볼 ");
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(hint_ball + hint_strike);
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
