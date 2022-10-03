package baseball.game;

import baseball.member.Computer;
import baseball.member.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    private static final String NUMBERS = "numbers";

    private Computer computer = new Computer();
    private User user = new User();
    private Score score = new Score();

    @Test
    void 모두_스트라이크() throws Exception {
        List<Integer> computerNums = Arrays.asList(new Integer[] {1, 2, 3});
        List<Integer> userNums = Arrays.asList(new Integer[] {1, 2, 3});

        setNumbers(computerNums, computer);
        setNumbers(userNums, user);

        score.judgeScore(computer, user);

        assertThat(score.getBall()).isEqualTo(0);
        assertThat(score.getStrike()).isEqualTo(3);
    }

    @Test
    void 두개의_볼_한개의_스트라이크() throws Exception {
        List<Integer> computerNums = Arrays.asList(new Integer[] {5, 6, 9});
        List<Integer> userNums = Arrays.asList(new Integer[] {5, 9, 6});

        setNumbers(computerNums, computer);
        setNumbers(userNums, user);

        score.judgeScore(computer, user);

        assertThat(score.getBall()).isEqualTo(2);
        assertThat(score.getStrike()).isEqualTo(1);
    }

    @Test
    void 모두_볼() throws Exception {
        List<Integer> computerNums = Arrays.asList(new Integer[] {4, 7, 9});
        List<Integer> userNums = Arrays.asList(new Integer[] {7, 9, 4});

        setNumbers(computerNums, computer);
        setNumbers(userNums, user);

        score.judgeScore(computer, user);

        assertThat(score.getBall()).isEqualTo(3);
        assertThat(score.getStrike()).isEqualTo(0);
    }

    private <T> void setNumbers(List<Integer> numbers, T t) throws Exception {
        Field comField = t.getClass().getDeclaredField(NUMBERS);
        comField.setAccessible(true);
        comField.set(t, numbers);
    }
}
