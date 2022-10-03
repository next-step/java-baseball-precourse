package baseball.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserTest extends AbstractDomainTest {

    @Test
    public void 숫자_입력_테스트() {
        String input = "123";
        User user = setInInput(input);
        List<Integer> numbers = user.getNumbers();
        Assertions.assertEquals(input.length(), numbers.size());
        for (int index = 0; index < input.length(); index++) {
            String inputNumber = input.split("")[index];
            Assertions.assertEquals(Integer.parseInt(inputNumber), numbers.get(index));
        }
    }

    @Test
    public void 숫자가_아닌_문자_입력_테스트() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            User user = setInInput("Illegal Character");
        });
    }

    @Test
    public void 범위를_초과하는_숫자_입력_테스트() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            User user = setInInput("1234");
        });
    }
}
