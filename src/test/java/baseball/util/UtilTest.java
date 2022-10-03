package baseball.util;


import static baseball.Application.DIGIT_FOR_GAME;
import static baseball.constant.BaseballNumberEnum.BEGINNING_CHARACTER;
import static baseball.constant.BaseballNumberEnum.INDEX_ONE_HUNDRED;
import static baseball.constant.BaseballNumberEnum.INDEX_ZERO;
import static baseball.constant.BaseballStringEnum.INVALID_NUMBER_FOR_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class UtilTest {

    @Test
    void makeRandomNumberInString() {
        Util util = new Util();
        String numberInString = util.makeRandomNumberInString();
        System.out.println(numberInString);
        List<Character> numberInChar = numberInString.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        assertThat(numberInChar).doesNotContain(INVALID_NUMBER_FOR_INPUT.label.charAt(0));
        assertThat(numberInChar).size().isEqualTo(DIGIT_FOR_GAME);
        char removed = numberInChar.remove(BEGINNING_CHARACTER.intValue.intValue());
        System.out.println(removed);
        assertThat(numberInChar).doesNotContain(removed);
    }

    @Test
    public void validationTest() {
        int count = INDEX_ZERO.intValue;
        while (count < INDEX_ONE_HUNDRED.intValue) {
            makeRandomNumberInString();
            count++;
        }
    }
}