package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("야구 게임 진행 상태 테스트")
public class BaseballGameStatusTest {

    @Test
    @DisplayName("입력 값이 1이면 PLAYING, 2이면 END, 그 외 ERROR")
    void create() {
        // when & then
        assertAll(
                () -> assertThat(BaseballGameStatus.of("1")).isEqualTo(BaseballGameStatus.PLAYING),
                () -> assertThat(BaseballGameStatus.of("2")).isEqualTo(BaseballGameStatus.ENDED),
                () -> assertThat(BaseballGameStatus.of("abc")).isEqualTo(BaseballGameStatus.ERROR)
        );
    }
}
