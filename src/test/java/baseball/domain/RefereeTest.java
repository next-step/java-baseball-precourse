package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RefereeTest {
    @Test
    void 입력값_룰체크_확인(){
        Referee referee = new Referee(3, Arrays.asList(1,2,3));
        //중복값
        referee.ruleCheck("111",1,9);
        List<Integer> inputList = referee.getInputList();
        assertThat(inputList).isEmpty();

        //문자열
        referee.ruleCheck("ddd",1,9);
        inputList = referee.getInputList();
        assertThat(inputList).isEmpty();

        //정상값
        referee.ruleCheck("123",1,9);
        inputList = referee.getInputList();
        assertThat(inputList).contains(1,2,3);
    }
}
