package baseball.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgementTest {

    private Judgement judgement;
    private List<Integer> computerNumbers;

    @BeforeEach
    public void setUp() {
        judgement = new Judgement();
        computerNumbers = new ArrayList<>();
    }

    @DisplayName("숫자 3개 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123:3스트라이크", "278:1볼", "729:1스트라이크", "456:낫싱", "138:1볼 1스트라이크"}, delimiter = ':')
    public void 볼_스트라이크_낫싱_숫자_매칭_테스트(String playerNumbers, String expected) {

        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        assertEquals(judgement.matchNumbers(computerNumbers, playerNumbers), expected);
    }


}
