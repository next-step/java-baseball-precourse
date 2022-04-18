package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InquirePlayerTest {
    InquirePlayer inquirePlayer;

    @BeforeEach
    public void setUp() {
        inquirePlayer = new InquirePlayer();
    }

    @Test
    @DisplayName("Exception이 발생하는지 확인하는 Test")
    public void thinkGoodInquireGameNumbersTest() {
        // Given

        // When

        // Then
        assertThatThrownBy(() -> {
            inquirePlayer.thinkGoodInquireGameNumbers("111");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 들어왔는지 체크하는 Test")
    public void isDigitGameNumbersSucessTest() {
        // Given
        boolean isDigit;

        // When
        isDigit = inquirePlayer.isDigitGameNumbers("425");

        // Then
        assertThat(isDigit)
                .isEqualTo(true)
        ;
    }

    @Test
    @DisplayName("숫자가 들어오지 않아서 예외 발생 체크하는 Test")
    public void isDigitGameNumbersFailTest() {
        // Given

        // When && Then
        Assertions.assertThatThrownBy(() -> inquirePlayer.isDigitGameNumbers("d2d"))
                .isInstanceOf(IllegalArgumentException.class)
        ;
    }

    @Test
    @DisplayName("같은 숫자가 들어왔는지 체크하는 Test")
    public void isSameGameNumbersTest() {
        // Given
        boolean isDigit;

        // When
        isDigit = inquirePlayer.isSameGameNumbers("123");

        // Then
        assertThat(isDigit)
                .isEqualTo(true)
        ;
    }

    @Test
    @DisplayName("같은 숫자가 들어와서 예외발생후 체크하는 Test")
    public void isSameGameNumbersFailTest() {
        // Given

        // When && Then
        Assertions.assertThatThrownBy(() -> inquirePlayer.isSameGameNumbers("333"))
                .isInstanceOf(IllegalArgumentException.class)
        ;
    }

    @Test
    @DisplayName("숫자 길이를 체크하는 Test")
    public void isValidGameNumbersLengthTest() {
        // Given
        boolean isDigit;

        // When
        isDigit = inquirePlayer.isValidGameNumbersLength("123");

        // Then
        assertThat(isDigit)
                .isEqualTo(true)
        ;
    }

    @Test
    @DisplayName("숫자 길이가 맞지 않아서 예외 발생 후 체크하는 Test")
    public void isValidGameNumbersLengthFailTest() {
        // Given

        // When && Then
        Assertions.assertThatThrownBy(() -> inquirePlayer.isValidGameNumbersLength("3"))
                .isInstanceOf(IllegalArgumentException.class)
        ;
    }
}