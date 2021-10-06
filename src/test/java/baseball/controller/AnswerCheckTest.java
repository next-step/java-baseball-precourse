package baseball.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerCheckTest {

    @Test
    @DisplayName("통합테스트진행")
    void 통합테스트(){
        //given
        AnswerCheck tc_1 = new AnswerCheck("123");
        tc_1.setUserInput("456");
        AnswerCheck tc_2 = new AnswerCheck("456");
        tc_2.setUserInput("123");
        AnswerCheck tc_3 = new AnswerCheck("156");
        tc_3.setUserInput("651");

        //when
        tc_1.checkPipeLine();
        tc_2.checkPipeLine();
        tc_3.checkPipeLine();

        //then
        Assertions.assertEquals(0, tc_1.getStrike());
        Assertions.assertEquals(0, tc_1.getBall());
        Assertions.assertEquals(0, tc_2.getStrike());
        Assertions.assertEquals(0, tc_2.getBall());
        Assertions.assertEquals(1, tc_3.getStrike());
        Assertions.assertEquals(2, tc_3.getBall());
    }
}
