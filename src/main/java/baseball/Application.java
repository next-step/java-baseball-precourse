package baseball;

import baseball.generator.InputGenerator;
import baseball.generator.NumberGenerator;
import baseball.validator.InputValidator;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        final List<Integer> answer = NumberGenerator.makeThreeDigits();
        while (true) {
            final String input = InputValidator.validateInput(InputGenerator.inputThreeDigits());

        }
    }
}
