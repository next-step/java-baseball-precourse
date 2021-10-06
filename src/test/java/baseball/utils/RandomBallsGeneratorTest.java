package baseball.utils;

import baseball.domain.ball.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("야구게임 숫자 모음 생성기 테스트")
class RandomBallsGeneratorTest {
    @ParameterizedTest(name = "야구게임 숫자 모음 생성 테스트")
    void 야구게임_숫자_모음_생성_테스트() {
        // given
        RandomBallsGenerator randomBallsGenerator = new RandomBallsGenerator();

        // when
        Balls balls = randomBallsGenerator.generate();

        // then
        assertThat(balls).isInstanceOf(Balls.class);
    }
}