package baseball.domains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("Play 메소드가 호출되면 세자리 숫자형 문자열을 입력해야한다.")
    void Should_InputNumericString_When_CallSwing() {
        // given
        final String input = "123";
        generateUserInput(input);
        // when
        player.play();
        // then
        assertThat(player.getAimPositions()).isEqualTo(input);
    }


    @Test
    @DisplayName("Aim position이 숫자형 문자열이 아니면 IllegalArgumentException이 발생한다.")
    void Should_OccurException_When_NonNumericString() {
        // given
        final String input = "a12";
        generateUserInput(input);
        // when
        final Throwable when = catchThrowable(() -> player.play());
        // then
        assertThat(when)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9사이 숫자만 입력해주세요");
    }

    // validateIsNumericString에서 먼저 걸러내기 때문에 숫자형 문자열이라는 것이 보장되므로 길이만 테스트한다.
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    @DisplayName("Aim position의 길이가 3이 아니면 IllegalArgumentException이 발생한다.")
    void Should_OccurException_When_LengthIsNot3(String input) {
        // given
        generateUserInput(input);
        // when
        final Throwable when = catchThrowable(() -> player.play());
        // then
        assertThat(when)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세자리 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("Aim position에 중복된 숫자가 있다면 IllegalArgumentException이 발생한다.")
    void Should_OccurException_When_DuplicatedRandomString() {
        // given
        generateUserInput("112");
        // when
        final Throwable when = catchThrowable(() -> player.play());
        // then
        assertThat(when)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 숫자를 입력해주세요.");
    }

    private void generateUserInput(String input) {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
