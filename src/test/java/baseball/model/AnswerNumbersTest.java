package baseball.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AnswerNumbersTest {

    @Test
    void 숫자로_이루어지_않으면_에러발생하는지 () {
        assertThatThrownBy(() -> {
            new AnswerNumbers("qwe");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~9 외 다른 문자는 유효하지 않습니다.");
    }

    @Test
    void 세자리아니면_에러발생하는지 () {
        assertThatThrownBy(() -> {
            new AnswerNumbers("1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 3자리로 입력해주세요.");
    }

    @Test
    void 정답에_0이_포함되면_에러발생하는지 () {
        assertThatThrownBy(() -> {
            new AnswerNumbers("120");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자는 \"0\"을 포함할 수 없습니다.");
    }
    @Test
    void 정답에_중복된_숫자가_있으면_에러발생하는지 () {
        assertThatThrownBy(() -> {
            new AnswerNumbers("121");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
    }

    @Test
    void 문자열이_Integer_LIST로_변환되는지 () {
        AnswerNumbers answerNumbers = new AnswerNumbers("159");
        List<Integer> list = answerNumbers.getNumberList();
        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            builder.append(integer);
        }
        assertThat(builder.toString()).isEqualTo("159");
    }

    @Test
    void 랜덤한_세자리_숫자가_생성되는지 () {
        AnswerNumbers answerNumbers = new AnswerNumbers();
        assertThat(answerNumbers.getNumberList().size()).isEqualTo(3);
    }

    @Test
    void Strike_Ball_개수_세기 () {
        AnswerNumbers answerNumbers = new AnswerNumbers("987");


        CheckResult result1 = answerNumbers.checkAnswer(new AnswerNumbers("123"));
        CheckResult result2 = answerNumbers.checkAnswer(new AnswerNumbers("912"));
        CheckResult result3 = answerNumbers.checkAnswer(new AnswerNumbers("917"));
        CheckResult result4 = answerNumbers.checkAnswer(new AnswerNumbers("987"));
        CheckResult result5 = answerNumbers.checkAnswer(new AnswerNumbers("789"));
        CheckResult result6 = answerNumbers.checkAnswer(new AnswerNumbers("879"));
        CheckResult result7 = answerNumbers.checkAnswer(new AnswerNumbers("728"));

        assertThat(result1.getStrike()).isEqualTo(0);
        assertThat(result2.getStrike()).isEqualTo(1);
        assertThat(result3.getStrike()).isEqualTo(2);
        assertThat(result4.getStrike()).isEqualTo(3);
        assertThat(result5.getStrike()).isEqualTo(1);
        assertThat(result6.getStrike()).isEqualTo(0);
        assertThat(result7.getStrike()).isEqualTo(0);

        assertThat(result1.getBall()).isEqualTo(0);
        assertThat(result2.getBall()).isEqualTo(0);
        assertThat(result3.getBall()).isEqualTo(0);
        assertThat(result4.getBall()).isEqualTo(0);
        assertThat(result5.getBall()).isEqualTo(2);
        assertThat(result6.getBall()).isEqualTo(3);
        assertThat(result7.getBall()).isEqualTo(2);
    }


}