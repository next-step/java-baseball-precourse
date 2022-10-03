package baseball.input;

import baseball.input.bean.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력 테스트")
public class PlayerNumberValidatorTest {
    private PlayerNumberValidator playerNumberValidator;
    private Player player;
    @BeforeEach
    void setUp() {
        this.player = new Player();
        this.playerNumberValidator = new PlayerNumberValidator();
    }

    @DisplayName("입력번호 set")
    @ParameterizedTest
    @ValueSource(strings = {
            "1", "2",
            "123", "321",
            "234", "432",
            "456", "654",
            "567", "765",
            "678", "876",
            "789", "987",
    })
    void validateNumberSuccess(String playerNumber) {
        assertThatNoException()
                .isThrownBy(() -> {
                    this.playerNumberValidator.validateNumber(playerNumber);
                });
    }

    @DisplayName("입력번호 set exception test")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "1234", "4321",
            "222", "111",
            "234a", "4b32",
            "-456", "-654",
            "567)(", "()765",
            "6!78", "87/1!6",
            "78\\vv9", "9\\v87",
    })
    void setNumberException(String playerNumber) {
        assertThatThrownBy(() -> {
            this.playerNumberValidator.validateNumber(playerNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}