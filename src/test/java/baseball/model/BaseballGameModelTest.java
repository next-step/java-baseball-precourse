package baseball.model;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class BaseballGameModelTest {

    @Nested
    class 새게임_세팅_테스트 {

        BaseballGameModel baseballGameModel = new BaseballGameModel();

        @Test
        void 초기화시_새게임속성_참() {
            Assertions.assertThat(baseballGameModel.getWantNewGame()).isTrue();
        }

        @Test
        void 초기화시_아직정답못맞힘_참() {
            Assertions.assertThat(baseballGameModel.getNotYetCollectAnswer()).isTrue();
        }

        @RepeatedTest(20)
        void 초기화시_유니크한세개의숫자() {
            //when
            Set<Integer> numberSet = new HashSet<>(Arrays.asList(baseballGameModel.getBallNumbers()));

            //then
            Assertions.assertThat(baseballGameModel.getBallNumbers().length).isEqualTo(3);
            Assertions.assertThat(numberSet.size()).isEqualTo(3);
        }

        @RepeatedTest(20)
        void 초기화시_숫자범위() {
            //then
            Assertions.assertThat(baseballGameModel.getBallNumbers())
                    .filteredOn(num -> num > 0 && num < 10)
                    .hasSize(3);
        }
    }
}