package baseball;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Umpire {
    public void validate(String input) {
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
    }

    public boolean getHint(LinkedHashSet<Integer> answer, String input) {
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
            return true;
        }

        String hint_strike = (strikeCount == 0) ? "" : (strikeCount + "스트라이크 ");
        String hint_ball = (ballCount == 0) ? "" : (ballCount + "볼 ");
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(hint_ball + hint_strike);
        }
        return false;
    }
}
