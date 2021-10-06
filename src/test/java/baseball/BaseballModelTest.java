package baseball;

import baseball.dto.BaseballResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballModelTest {

    @Nested
    @DisplayName("컴퓨터 숫자 생성 테스트")
    class TestComputerNumber {

        @Test
        @Order(1)
        @DisplayName("숫자 양식 검증")
        void 컴퓨터_숫자_생성() {
            // given
            BaseballModel baseballModel = new BaseballModel();

            // when
            baseballModel.initComputerNumber();
            String computerNumber = baseballModel.getComputerNumber();
            int numberSize = baseballModel.getNumberSize();

            // then
            assertThat(computerNumber.length()).isEqualTo(numberSize);
            for (int i = 0; i < numberSize; i++) {
                assertThat(computerNumber.charAt(i) - '0').isBetween(1, 9);
                for (int j = i + 1; j < numberSize; j++) {
                    assertThat(computerNumber.charAt(i)).isNotEqualTo(computerNumber.charAt(j));
                }
            }
        }
    }

    @Nested
    @DisplayName("볼카운트 계산 테스트")
    class TestCountStrikeBall{

        @Test
        @DisplayName("3스트라이크")
        void countStrikeBall1() {
            // given
            BaseballModel baseballModel = new BaseballModel();
            baseballModel.initComputerNumber();

            // when
            String computerNumber = baseballModel.getComputerNumber();
            BaseballResult baseballResult = baseballModel.countStrikeBall(computerNumber);

            // then
            assertThat(baseballResult.getStrike()).isEqualTo(3);
            assertThat(baseballResult.getBall()).isEqualTo(0);
            assertThat(baseballResult.getResultCode()).isEqualTo("S");
        }

        @Test
        @DisplayName("1스트라이크 2볼")
        void countStrikeBall2() {
            // given
            BaseballModel baseballModel = new BaseballModel();
            baseballModel.initComputerNumber();

            // when
            StringBuffer sb = new StringBuffer(baseballModel.getComputerNumber());
            BaseballResult baseballResult = baseballModel.countStrikeBall(sb.reverse().toString());

            // then
            assertThat(baseballResult.getStrike()).isEqualTo(1);
            assertThat(baseballResult.getBall()).isEqualTo(2);
            assertThat(baseballResult.getResultCode()).isEqualTo("F");
        }

        @Test
        @DisplayName("3볼")
        void countStrikeBall3() {
            // given
            BaseballModel baseballModel = new BaseballModel();
            baseballModel.initComputerNumber();

            // when
            String computerNumber = baseballModel.getComputerNumber();
            computerNumber = computerNumber + computerNumber.charAt(0);
            computerNumber = computerNumber.substring(1);
            BaseballResult baseballResult = baseballModel.countStrikeBall(computerNumber);

            // then
            assertThat(baseballResult.getStrike()).isEqualTo(0);
            assertThat(baseballResult.getBall()).isEqualTo(3);
            assertThat(baseballResult.getResultCode()).isEqualTo("F");
        }
    }

    @Nested
    @DisplayName("입력 오류 테스트")
    class TestErrorInput {

        @Test
        @DisplayName("입력형식 오류 - 중복숫자입력")
        void countStrikeBall4() {
            // given
            BaseballModel baseballModel = new BaseballModel();
            baseballModel.initComputerNumber();

            // when
            BaseballResult baseballResult = baseballModel.countStrikeBall("111");

            // then
            assertThat(baseballResult.getStrike()).isEqualTo(0);
            assertThat(baseballResult.getBall()).isEqualTo(0);
            assertThat(baseballResult.getResultCode()).isEqualTo("E");
        }

        @Test
        @DisplayName("입력형식 오류 - 자리수초과")
        void countStrikeBall5() {
            // given
            BaseballModel baseballModel = new BaseballModel();
            baseballModel.initComputerNumber();

            // when
            BaseballResult baseballResult = baseballModel.countStrikeBall("1234");

            // then
            assertThat(baseballResult.getStrike()).isEqualTo(0);
            assertThat(baseballResult.getBall()).isEqualTo(0);
            assertThat(baseballResult.getResultCode()).isEqualTo("E");
        }

        @Test
        @DisplayName("입력형식 오류 - 문자입력")
        void countStrikeBall6() {
            // given
            BaseballModel baseballModel = new BaseballModel();
            baseballModel.initComputerNumber();

            // when
            BaseballResult baseballResult = baseballModel.countStrikeBall("a23");

            // then
            assertThat(baseballResult.getStrike()).isEqualTo(0);
            assertThat(baseballResult.getBall()).isEqualTo(0);
            assertThat(baseballResult.getResultCode()).isEqualTo("E");
        }
    }


}
