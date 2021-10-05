package baseball.domain;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.*;

public class Game {
    public static final int MIN_NO = 1; // 랜덤 숫자 최소값
    public static final int MAX_NO = 9; // 랜덤 숫자 최대값
    public static final int BALL_MAX_COUNT = 3; // 입력 볼 최대 개수

    List<Integer> computerBalls; // 컴퓨터 볼

    public Game() {}

    // 게임 시작
    public void start() {
        this.computerBalls = createThreeRandomBalls();
    }

    // 사용자 볼 입력받기
    public List<Integer> getBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        return convertToListOfInteger(readNumber());
    }

    // 숫자만 입력받기
    public String readNumber() {
        String numbers = "init";
        while(!ValidationUtils.checkIsNumber(numbers)) {
            numbers = Console.readLine();
        }
        return numbers;
    }

    // 랜덤한 3개의 숫자 생성
    public List<Integer> createThreeRandomBalls() {
        Set<Integer> balls = new HashSet<>();
        while(balls.size() < 3) {
            balls.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(balls);
    }

    // 문자열을 Int 배열로 변환
    public List<Integer> convertToListOfInteger(String numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            result.add(Character.getNumericValue(numbers.charAt(i)));
        }
        return result;
    }
}
