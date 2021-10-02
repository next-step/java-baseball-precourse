package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareResultTest {
    @Test
    void 스트라이크와_볼이_0일_때_낫싱이_참인지() {
        CompareResult compareResult = new CompareResult(0, 0);
        assertThat(compareResult.isNothing() == true);
    }

    @Test
    void 스트라이크나_볼이_0이_아닐때_낫싱이_거짓인지() {
        CompareResult compareResult1 = new CompareResult(1, 0);
        CompareResult compareResult2 = new CompareResult(0, 1);
        assertThat(compareResult1.isNothing() == false);
        assertThat(compareResult2.isNothing() == false);
    }

    @Test
    void 스트라이크가_야구번호_개수와_일치할_때_석세스가_참인지() {
        CompareResult compareResult = new CompareResult(BaseballNumber.BASEBALL_SIZE, 0);
        assertThat(compareResult.isSuccess() == true);
    }

    @Test
    void 스트라이크가_야구번호_개수와_일치하지_않을_때_석세스가_거짓인지() {
        CompareResult compareResult = new CompareResult(BaseballNumber.BASEBALL_SIZE - 1, 0);
        assertThat(compareResult.isSuccess() == false);
    }
}