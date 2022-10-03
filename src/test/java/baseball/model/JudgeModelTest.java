package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import baseball.code.JudgeStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JudgeModelTest {

    Integer[] BALL_NUMBERS = {1, 2, 3};

    @Nested
    class 볼_테스트 {

        @Test
        void 볼_1개_테스트(){

            Integer[] inputNumbers = {3, 4, 5};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getBallCount()).isEqualTo(1);
            Assertions.assertThat(judgeModel.getJudgeStatus()).isEqualTo(JudgeStatus.BALL);
        }

        @Test
        void 볼_2개_테스트(){

            Integer[] inputNumbers = {5, 1, 2};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getBallCount()).isEqualTo(2);
            Assertions.assertThat(judgeModel.getJudgeStatus()).isEqualTo(JudgeStatus.BALL);
        }

        @Test
        void 볼_3개_테스트(){

            Integer[] inputNumbers = {2, 3, 1};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getBallCount()).isEqualTo(3);
            Assertions.assertThat(judgeModel.getJudgeStatus()).isEqualTo(JudgeStatus.BALL);
        }

        @Test
        void 볼_없음_테스트(){

            Integer[] inputNumbers = {4, 5, 6};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getBallCount()).isEqualTo(0);
            Assertions.assertThat(judgeModel.getJudgeStatus()).isEqualTo(JudgeStatus.NOTHING);
        }
    }

    @Nested
    class 스트라이크_테스트 {

        @Test
        void 스트라이크_테스트_1개_테스트(){

            Integer[] inputNumbers = {1, 4, 5};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getStrikeCount()).isEqualTo(1);
        }

        @Test
        void 스트라이크_테스트_2개_테스트(){

            Integer[] inputNumbers = {1, 2, 5};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getStrikeCount()).isEqualTo(2);
        }

        @Test
        void 스트라이크_테스트_3개_테스트(){

            Integer[] inputNumbers = {1, 2, 3};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getStrikeCount()).isEqualTo(3);
            Assertions.assertThat(judgeModel.getJudgeStatus()).isEqualTo(JudgeStatus.STRIKE);
        }

        @Test
        void 스트라이크_테스트_없음_테스트(){

            Integer[] inputNumbers = {4, 5, 6};

            JudgeModel judgeModel = new JudgeModel(inputNumbers, BALL_NUMBERS);
            Assertions.assertThat(judgeModel.getStrikeCount()).isEqualTo(0);
            Assertions.assertThat(judgeModel.getJudgeStatus()).isEqualTo(JudgeStatus.NOTHING);
        }
    }

}