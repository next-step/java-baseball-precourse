package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BaseballPlayer 테스트")
class BaseballPlayerTest {

    private final int NUMBER_SIZE = 3;

    @Nested
    @DisplayName("computer()")
    class Describe_ComputerMethod {

        @Test
        @DisplayName("중복되지 않는 3개의 숫자 List를 가진 객체를 반환한다.")
        void It_ThreeSizeAndNotDuplicated() {
            BaseballPlayer computer = BaseballPlayer.computer();
            assertThat(computer.getNumbers().size()).isEqualTo(NUMBER_SIZE);

            int[] numberCount = new int[10];
            List<Integer> numbers = computer.getNumbers();
            for (int number : numbers) {
                numberCount[number]++;
            }

            for (int number : numbers) {
                assertThat(numberCount[number]).isLessThan(2);
            }
        }
    }

    @Nested
    @DisplayName("user()")
    class Describe_UserMethod{

        @Nested
        @DisplayName("중복되지 않는 숫자로 이루어진 문자열 3글자를 전달하면")
        class Context_InputNumber{

            private final String numbers = "379";

            @Test
            @DisplayName("숫자 3개의 List를 가진 객체를 반환한다.")
            void It_ReturnUser(){
                BaseballPlayer user = BaseballPlayer.user(numbers);
                List<Integer> userNumbers = user.getNumbers();

                for (int i = 0; i < userNumbers.size(); i++) {
                    int number = userNumbers.get(i);
                    assertThat(number).isEqualTo(numbers.charAt(i) - 48);
                }
            }
        }
    }

    @Nested
    @DisplayName("compare()")
    class Describe_CompareMethod{

        @Nested
        @DisplayName("호출한 플레이어는 [1,2,3]을 가지고 있다면")
        class Context_CallMethodPlayer_Has_123{

            private final BaseballPlayer PLAYER = BaseballPlayer.user("123");

            @Nested
            @DisplayName("상대 플레이어가 [1,2,4]를 가지고 있다면")
            class Context_OtherPlayer_Has_124{

                private final BaseballPlayer OTHER_PLAYER = BaseballPlayer.user("124");

                @Test
                @DisplayName("2스트라이크를 반환한다.")
                void It_TwoStrike(){
                    BaseballResult result = PLAYER.compare(OTHER_PLAYER);

                    assertThat(result.getResultScore()).isEqualTo("2스트라이크");
                }
            }

            @Nested
            @DisplayName("상대 플레이어가 [3,2,1]를 가지고 있다면")
            class Context_OtherPlayer_Has_321{

                private final BaseballPlayer OTHER_PLAYER = BaseballPlayer.user("321");

                @Test
                @DisplayName("2볼 1스트라이크를 반환한다.")
                void It_TowBallOneStrike(){
                    BaseballResult result = PLAYER.compare(OTHER_PLAYER);

                    assertThat(result.getResultScore()).isEqualTo("2볼 1스트라이크");
                }
            }

            @Nested
            @DisplayName("상대 플레이어가 [3,1,2]를 가지고 있다면")
            class Context_OtherPlayer_Has_312{

                private final BaseballPlayer OTHER_PLAYER = BaseballPlayer.user("312");

                @Test
                @DisplayName("3볼을 반환한다.")
                void It_TowBallOneStrike(){
                    BaseballResult result = PLAYER.compare(OTHER_PLAYER);

                    assertThat(result.getResultScore()).isEqualTo("3볼");
                }
            }

            @Nested
            @DisplayName("상대 플레이어가 [7,8,9]를 가지고 있다면")
            class Context_OtherPlayer_Has_789{

                private final BaseballPlayer OTHER_PLAYER = BaseballPlayer.user("789");

                @Test
                @DisplayName("낫싱을 반환한다.")
                void It_TowBallOneStrike(){
                    BaseballResult result = PLAYER.compare(OTHER_PLAYER);

                    assertThat(result.getResultScore()).isEqualTo("낫싱");
                }
            }
        }
    }
}
