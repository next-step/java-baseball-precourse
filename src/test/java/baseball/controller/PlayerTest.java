package baseball.controller;

import baseball.model.enums.UserSelect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Player: 사용자의 Input, Output 과 직접적으로 연결되어 있는 Controller")
public class PlayerTest {

    @DisplayName("처음 생성되었을 때는 READY 상태")
    @Test
    void testConstructor() {
        Player player = new Player();
        assertThat(player.isReady()).isTrue();
    }

    @DisplayName("새 게임을 시작하면 PLAYING 상태이면서 정답을 맞추기 전인 상태")
    @Test
    void testStartNewGame() {
        Player player = new Player();

        player.startNewGame(Arrays.asList(1, 2, 3));

        assertThat(player.isReady()).isFalse();
        assertThat(player.isPlayingWithWrongAnswer()).isTrue();
    }

    @DisplayName("게임 시작 후 정답을 맞추려고 하면 사용자에게 출력할 결과 메세지를 알려줌")
    @ParameterizedTest
    @CsvSource(value = {
            "456, 낫싱",
            "123, 3스트라이크",
            "415, 1볼",
            "124, 2스트라이크",
            "321, 1스트라이크 2볼",
            "312, 3볼",
            "1242, 비교하려는 두 Balls 의 크기가 다릅니다. 입력값:4 정답:3"
    })
    void testGuessAnswer(String input, String message) {
        Player player = new Player();

        player.startNewGame(Arrays.asList(1, 2, 3));
        String output = player.guessAnswer(input);

        assertThat(player.isReady()).isFalse();
        assertThat(output).isEqualTo(message);
    }

    @DisplayName("정답을 맞추면 AnswerStatus 가 RIGHT 로 변경됨")
    @Test
    void testCorrectAnswer() {
        Player player = new Player();

        player.startNewGame(Arrays.asList(1, 2, 3));
        String output = player.guessAnswer("123");

        assertThat(output).isEqualTo("3스트라이크");
        assertThat(player.isReady()).isFalse();
        assertThat(player.isPlayingWithWrongAnswer()).isFalse();
        assertThat(player.alreadyGetRightAnswer()).isTrue();
    }

    @DisplayName("사용자가 1을 선택하면 READY, 2를 선택하면 END 상태로 변경")
    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, false"
    })
    void testRestartOrExit(String stringNumber, boolean isReady) {
        Player player = new Player();

        player.startNewGame(Arrays.asList(1, 2, 3));
        player.guessAnswer("123");
        player.restartOrExit(UserSelect.of(stringNumber));

        assertThat(player.isReady()).isEqualTo(isReady);
    }
}
