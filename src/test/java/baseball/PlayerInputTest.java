package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerInputTest {

    PlayerInput playerInput;

    @BeforeEach
    void setUp() {
        playerInput = new PlayerInput();
    }

    @Test
    @DisplayName("정상적인 입력이 들어왔을때의 테스트")
    void getPlayerNumber() {
        String input = "123";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<Integer> playerNumbers = playerInput.getPlayerNumber();
        assertThat(playerNumbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(strings = {"12", "12a"})
    @DisplayName("비정상적인 입력이 들어왔을때의 테스트")
    void getPlayerNumberTestForException(String input) {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> {
            List<Integer> playerNumbers = playerInput.getPlayerNumber();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 숫자");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,false"})
    @DisplayName("게임 재시작 및 종료를 위한 입력 테스트(정상입력)")
    void doAgain(String number, String expected) {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        InputStream inputStream = new ByteArrayInputStream(number.getBytes());
        System.setIn(inputStream);
        assertThat(playerInput.doAgain()).isEqualTo(Boolean.parseBoolean(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "3"})
    @DisplayName("게임 재시작 및 종료를 위한 입력 테스트(비정상입력)")
    void doAgainForIllegalArgumentException(String number) {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        InputStream inputStream = new ByteArrayInputStream(number.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> {
            playerInput.doAgain();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 숫자");
    }
}