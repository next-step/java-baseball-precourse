package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BaseballNumberTest {
    @Test
    void 세자리의_다른숫자로_자동생성하는_기능() {
        BaseballNumber baseballNumber = BaseballNumber.generate();
        assertThat(baseballNumber.getBallNumbers().size() == 3);
    }

    @Test
    void 규칙에_일치하는_문자열_입력시_잘_생성되는지() {
        BaseballNumber baseballNumber = new BaseballNumber("123");
        assertThat(baseballNumber.getBallNumbers().size() == 3);
        assertThat(baseballNumber.toString()).contains("1", "2", "3");
    }

    @Test
    void 자릿수_맞지않는_문자열_입력시_에러발생_하는지() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumber("1234"))
                .withMessageContaining("[ERROR]", "자리의");
    }

    @Test
    void 중복된_숫자를_가진_문자열_입력시_에러발생_하는지지() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumber("112"))
                .withMessageContaining("[ERROR]", "중복");
    }

    @Test
    void 숫자가_아닌_문자를_포함한_문자열_입력시_에러발생_하는지() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumber("1a2"))
                .withMessageContaining("[ERROR]", "숫자만");
    }

    @Test
    void 정답을_맞췄을_때_비교결과값의_석세스가_참인지() {
        BaseballNumber answer = new BaseballNumber("123");
        BaseballNumber input = new BaseballNumber("123");
        CompareResult compareResult = answer.compare(input);
        assertThat(compareResult.isSuccess() == true);
    }

    @Test
    void 정답과_완전_다른입력일_때_비교결과값의_낫싱이_참인지() {
        BaseballNumber answer = new BaseballNumber("123");
        BaseballNumber input = new BaseballNumber("456");
        CompareResult compareResult = answer.compare(input);
        assertThat(compareResult.isNothing() == true);
    }

    @Test
    void 정답과_비교하여_스트라이크와_볼이_있을_경우_비교결과값_확인() {
        BaseballNumber answer = new BaseballNumber("123");
        BaseballNumber input = new BaseballNumber("132");
        CompareResult compareResult = answer.compare(input);
        assertThat(compareResult.getStrike() == 1 && compareResult.getBall() == 2);
    }
}