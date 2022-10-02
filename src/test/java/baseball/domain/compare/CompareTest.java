package baseball.domain.compare;

import baseball.game.GameResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompareTest {

    private Compare compare;
    @BeforeEach
    void setUp(){
        compare = new Compare();
    }


    @Test
    public void 스트라이트_테스트(){
        List<Integer> testNum = Arrays.asList(245);
        GameResult result = compare.compareTwoNumber(267, testNum);

        String expected = "1스트라이크";

        assertThat(result.toString()).isEqualTo(expected);


    }

    @Test
    public void 낫싱_테스트(){
        List<Integer> testNum = Arrays.asList(245);
        GameResult result = compare.compareTwoNumber(789, testNum);

        String expected = "낫싱";

        assertThat(result.toString()).isEqualTo(expected);


    }

    @Test
    public void 볼_테스트(){
        List<Integer> testNum = Arrays.asList(245);
        GameResult result = compare.compareTwoNumber(729, testNum);

        String expected = "1볼";

        assertThat(result.toString()).isEqualTo(expected);


    }

    @Test
    public void 볼_스트라이크_테스트(){
        List<Integer> testNum = Arrays.asList(245);
        GameResult result = compare.compareTwoNumber(425, testNum);

        String expected = "2볼 1스트라이크";

        assertThat(result.toString()).isEqualTo(expected);


    }

}