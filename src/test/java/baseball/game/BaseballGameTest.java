package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * author : hyeongju
 * date : 2022.09.28
 * description : 게임을 테스트한다.
 */
public class BaseballGameTest extends NsTest {

    @DisplayName("입력받은 숫자가 3자리인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void valid3length(String input){
        String regx = "^[1-9]{3}$";

        boolean matches = input.matches(regx);

        System.out.println(matches); // TODO:: 테스트 후 제거
        assertThat(matches);

    }

    @DisplayName("입력받은 숫자가 중복이 없는지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"123","234"})
    void validDuplicateTest(String input){
        String[] split = input.split("");

        Set<Integer> numbers = new HashSet<>();
        for (String s: split){
            numbers.add(Integer.parseInt(s));
        }

        assertThat(numbers.size() == 3);

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
