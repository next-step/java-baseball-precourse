package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OpinionInputTest {

    @DisplayName("올바른 Opinion 입력 체크")
    @Test
    void checkOpinionInputValidate() {
        String userinput = "3";
        OpinionInput opinion = new OpinionInput();

        assertThat(opinion.checkUserOpinionValidate(userinput)).isFalse();

    }
}
