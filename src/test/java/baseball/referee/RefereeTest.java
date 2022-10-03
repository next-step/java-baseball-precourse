package baseball.referee;

import baseball.ball.Ball;
import baseball.constant.HintConstant;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    @DisplayName("상대방과 사용자의 볼 비교시 정답")
    public void answer_test() {
        RefereeResult answerResult = RefereeResult.create(CompareResult.ANSWER);
        Ball opponent = new Ball(Arrays.asList(1, 2, 3));
        Ball user = new Ball(Arrays.asList(1, 2, 3));

        Referee referee = new Referee();
        RefereeResult refereeResult = referee.compareTwoBalls(opponent, user);

        assertThat(answerResult.getCompareResult()).isEqualTo(refereeResult.getCompareResult());
    }

    @Test
    @DisplayName("상대방과 사용자의 볼 비교시 낫싱")
    public void nothing_test() {
        RefereeResult answerResult = RefereeResult.create(CompareResult.WRONG, HintConstant.NOTHING);

        Ball opponent = new Ball(Arrays.asList(1, 2, 3));
        Ball user = new Ball(Arrays.asList(4, 5, 6));

        Referee referee = new Referee();
        RefereeResult refereeResult = referee.compareTwoBalls(opponent, user);

        assertThat(answerResult.getCompareResult()).isEqualTo(refereeResult.getCompareResult());
        assertThat(answerResult.getHint()).isEqualTo(refereeResult.getHint());
    }

    @Test
    @DisplayName("상대방과 사용자의 볼 비교시 1볼")
    public void one_ball_test() {
        RefereeResult answerResult = RefereeResult.create(CompareResult.WRONG, String.format(HintConstant.BALL, 1));

        Ball opponent = new Ball(Arrays.asList(1, 2, 3));
        Ball user = new Ball(Arrays.asList(4, 1, 6));
        Referee referee = new Referee();
        RefereeResult refereeResult = referee.compareTwoBalls(opponent, user);

        assertThat(answerResult.getCompareResult()).isEqualTo(refereeResult.getCompareResult());
        assertThat(answerResult.getHint()).isEqualTo(refereeResult.getHint());
    }

    @Test
    @DisplayName("상대방과 사용자의 볼 비교시 1스트라이크")
    public void one_strike_ball() {
        RefereeResult answerResult = RefereeResult.create(CompareResult.WRONG, String.format(HintConstant.STRIKE, 1));

        Ball opponent = new Ball(Arrays.asList(1, 2, 3));
        Ball user = new Ball(Arrays.asList(1, 4, 5));
        Referee referee = new Referee();
        RefereeResult refereeResult = referee.compareTwoBalls(opponent, user);

        assertThat(answerResult.getCompareResult()).isEqualTo(refereeResult.getCompareResult());
        assertThat(answerResult.getHint()).isEqualTo(refereeResult.getHint());
    }
    @Test
    @DisplayName("상대방과 사용자의 볼 비교시 1볼 1스트라이크")
    public void one_ball_one_strike_ball() {
        RefereeResult answerResult = RefereeResult.create(CompareResult.WRONG, Strings.concat(String.format(HintConstant.BALL, 1),String.format(HintConstant.STRIKE, 1)));

        Ball opponent = new Ball(Arrays.asList(1, 2, 3));
        Ball user = new Ball(Arrays.asList(1, 3, 5));
        Referee referee = new Referee();
        RefereeResult refereeResult = referee.compareTwoBalls(opponent, user);

        assertThat(answerResult.getCompareResult()).isEqualTo(refereeResult.getCompareResult());
        assertThat(answerResult.getHint()).isEqualTo(refereeResult.getHint());
    }
}
