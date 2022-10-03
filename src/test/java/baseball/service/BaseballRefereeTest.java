package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("BaseballReferee 테스트")
class BaseballRefereeTest {

    private final Referee baseballReferee = new BaseballReferee();

    @Nested
    @DisplayName("checkCommand()")
    class Describe_CheckCommand{

        @Nested
        @DisplayName("입력이 null이라면")
        class Context_CommandIsNull{

            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void It_ThrowsNullException(){
                assertThatThrownBy(() -> baseballReferee.checkCommand(null))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("입력이 숫자 야구 사이즈와 다르다면")
        class Context_CommandDiffSize{

            private final String COMMAND = "1234";

            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void It_ThrowSizeException(){
                assertThatThrownBy(() -> baseballReferee.checkCommand(COMMAND))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("숫자가 아닌 입력값이 들어온다면")
        class Context_CommandContainsNonDigit{

            private final String COMMAND = "1A2";

            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void It_ThrowNonDigitException(){
                assertThatThrownBy(() -> baseballReferee.checkCommand(COMMAND))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("입력값 숫자가 중복되었다면")
        class Context_CommandDuplicateNumber{

            private final String COMMAND = "227";

            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void It_ThrowDuplicateException(){
                assertThatThrownBy(() -> baseballReferee.checkCommand(COMMAND))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
