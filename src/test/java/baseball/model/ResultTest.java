package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void 결과가_낫싱() {
        Result result = Result.nothing();

        assertThat(result.getResult()).isEqualTo("낫싱");
    }
    
    @Test
    void 결과가_1볼() {
        Result result = Result.ball();

        assertThat(result.getResult()).isEqualTo("1볼");
    }

    @Test
    void 결과가_1스트라이크() {
        Result result = Result.strike();

        assertThat(result.getResult()).isEqualTo("1스트라이크");
    }

    @Test
    void 결과가_3스트라이크() {
        Result result = Result.strike();
        Result round2Result = result.add(Result.strike());
        Result round3Result = round2Result.add(Result.strike());

        assertThat(round3Result.isFinish()).isTrue();
    }
}