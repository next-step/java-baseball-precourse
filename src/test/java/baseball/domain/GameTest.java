package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game(new FakeNumberGenerator());
    }

    @DisplayName("입력값으로 결과를 계산한다.")
    @Test
    void input() {
        Score score = game.input("123");
        assertThat(score.getText()).isEqualTo("1스트라이크 1볼");
    }

    @DisplayName("랜덤값을 업데이트한다.")
    @Test
    void update() {
        game.update();
        assertThat(game.getRandomNumbers()).isEqualTo(new Numbers("713"));
    }

    class FakeNumberGenerator implements RandomGenerator {

        @Override
        public String getValue() {
            return "713";
        }
    }
}