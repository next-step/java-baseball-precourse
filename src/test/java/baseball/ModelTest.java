package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import baseball.model.Result;
import baseball.model.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ModelTest {

    @Test
    void strikeResultTest() {
        User user = new User("123");

        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        Result result = new Result();
        result.createResult(user, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 3),
                () -> assertThat(result.getBall().getCount() == 0)
        );
    }

    @Test
    void ballResultTest() {
        User user = new User("123");

        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(3);
        computerNumbers.add(1);
        computerNumbers.add(2);

        Result result = new Result();
        result.createResult(user, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 0),
                () -> assertThat(result.getBall().getCount() == 3)
        );
    }

    @Test
    void nothingResultTest() {
        User user = new User("123");

        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(4);
        computerNumbers.add(5);
        computerNumbers.add(6);

        Result result = new Result();
        result.createResult(user, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 0),
                () -> assertThat(result.getBall().getCount() == 0)
        );
    }

    @Test
    void combinedResultTest_2Strikes_1Nothing() {
        User user = new User("123");

        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(4);

        Result result = new Result();
        result.createResult(user, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 2),
                () -> assertThat(result.getBall().getCount() == 0)
        );
    }

    @Test
    void combinedResultTest_1Strikes_2Balls() {
        User user = new User("123");

        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(3);
        computerNumbers.add(2);

        Result result = new Result();
        result.createResult(user, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 1),
                () -> assertThat(result.getBall().getCount() == 2)
        );
    }

    @Test
    void combinedResultTest_1Strike_1Ball() {
        User user = new User("123");
        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(5);
        computerNumbers.add(2);

        Result result = new Result();
        result.createResult(user, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 1),
                () -> assertThat(result.getBall().getCount() == 1)
        );
    }

    @Test
    void userTest() {
        final String input = "123";
        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(2);
        expectedNumbers.add(3);

        User user = new User(input);

        assertAll(
                () -> assertThat(user.getNumbers().containsAll(expectedNumbers))
        );
    }

    @Test
    void userExceptionTest_LongerThanMaxLength() {
        final String input = "1234";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new User(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void userExceptionTest_NullInput() {
        final String input = null;

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new User(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void userExceptionTest_BlankInput() {
        final String input = "";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new User(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
