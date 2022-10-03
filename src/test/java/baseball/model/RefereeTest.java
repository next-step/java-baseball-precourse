package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest extends AbstractDomainTest {

    @Test
    public void 정답_판정_테스트() {
        Computer computer = new Computer();
        User user = 정답_유저_생성(computer);
        boolean 판정_결과 = 판정_결과(computer, user);
        Assertions.assertFalse(판정_결과);
    }

    @Test
    public void 오답_판정_테스트() {
        Computer computer = new Computer();
        User user = 오답_유저_생성(computer);
        boolean 판정_결과 = 판정_결과(computer, user);
        Assertions.assertTrue(판정_결과);
    }

    private User 정답_유저_생성(Computer computer) {
        StringBuilder builder = new StringBuilder();
        for (int answer : computer.getNumbers()) {
            builder.append(answer);
        }
        return setInInput(builder.toString());
    }

    private User 오답_유저_생성(Computer computer) {
        List<Integer> noAnswers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int answer : computer.getNumbers()) {
            noAnswers.remove((Integer) answer);
        }
        StringBuilder builder = new StringBuilder();
        for (int count = 0; count < 3; count++) {
            builder.append(noAnswers.get(count));
        }
        return setInInput(builder.toString());
    }

    private boolean 판정_결과(Computer computer, User user) {
        Referee referee = new Referee();
        referee.judgeInning(computer, user);
        return referee.continuesGame();
    }
}