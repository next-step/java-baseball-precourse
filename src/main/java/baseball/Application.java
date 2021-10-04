package baseball;

import baseball.generator.NumberGenerator;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        final Set<Integer> answer = NumberGenerator.makeThreeDigits();
    }
}
