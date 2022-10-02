package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.dto.BaseballGameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameServiceTest {

    private  BaseballGameService baseballGameService;

    @BeforeEach
    void setUp() {
        baseballGameService = new BaseballGameService();
    }

    @DisplayName("상대방의 수와 입력한 수의 3자리가 전부 일치하면 승리한다")
    @Test
    void whenOpponentNumberMatchEnteredNumber_thenFinishGame() {
        // given
        BaseballNumber opponent = new BaseballNumber("123");
        BaseballNumber player = new BaseballNumber("123");

        // when
        BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(opponent, player);

        // then
        assertThat(baseballGameResultDto.isFinishGame()).isTrue();
    }

    @DisplayName("상대방의 수와 입력한 수 중 같은 자리의 수가 있으면 스트라이크를 반환한다")
    @Test
    void whenOpponentAndPlayerSameNumberIsSameIndex_thenReturnStrike() {
        // given
        BaseballNumber opponent = new BaseballNumber("253");
        BaseballNumber player = new BaseballNumber("213");

        // when
        BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(opponent, player);

        // then
        assertThat(baseballGameResultDto.getStrike()).isEqualTo(2);
        assertThat(baseballGameResultDto.getBall()).isEqualTo(0);
    }

    @DisplayName("상대방의 수와 입력한 수 중 다른 자리의 수가 있으면 볼을 반환한다")
    @Test
    void whenOpponentAndPlayerSameNumberIsDifferentIndex_thenReturnStrike() {
        // given
        BaseballNumber opponent = new BaseballNumber("123");
        BaseballNumber player = new BaseballNumber("312");

        // when
        BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(opponent, player);

        // then
        assertThat(baseballGameResultDto.getStrike()).isEqualTo(0);
        assertThat(baseballGameResultDto.getBall()).isEqualTo(3);
    }

    @DisplayName("상대방의 수와 입력한 수 중 같은 수가 없으면 0 strike, 0 ball 을 반환한다")
    @Test
    void whenOpponentAndPlayerNumberIsNotExistSameNumber_thenReturnZeroStrikeAndZeroBall() {
        // given
        BaseballNumber opponent = new BaseballNumber("123");
        BaseballNumber player = new BaseballNumber("456");

        // when
        BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(opponent, player);

        // then
        assertThat(baseballGameResultDto.getStrike()).isEqualTo(0);
        assertThat(baseballGameResultDto.getBall()).isEqualTo(0);
    }

    @DisplayName("상대방의 수와 입력한 수 중 같은 자리의 수와 같은 수가 다른 자리에 있는 수가 있다면 strike 와 ball 의 개수를 반환한다")
    @Test
    void whenOpponentAndPlayerNumberIsSameOrDifferentIndex_thenReturnStrikeAndBallCount() {
        // given
        BaseballNumber opponent = new BaseballNumber("153");
        BaseballNumber player = new BaseballNumber("513");

        // when
        BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(opponent, player);

        // then
        assertThat(baseballGameResultDto.getStrike()).isEqualTo(1);
        assertThat(baseballGameResultDto.getBall()).isEqualTo(2);
    }
}