package baseball.member;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private static final int NUM_SIZE = 3;
    private static final String SET_NUMBERS = "setNumbers";
    private static final String NUMBERS = "numbers";

    @Test
    void 문자열을_숫자_리스트로_변환() throws Exception {
        User user = new User();
        String input = "123";

        Method method = user.getClass().getDeclaredMethod(SET_NUMBERS, String.class);
        method.setAccessible(true);
        method.invoke(user, input);

        Field field = user.getClass().getDeclaredField(NUMBERS);
        field.setAccessible(true);

        List<Integer> numbers = (List<Integer>) field.get(user);
        assertThat(numbers.size()).isEqualTo(NUM_SIZE);
    }
}
