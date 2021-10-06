package baseball.aggregate;

import baseball.domain.Computer;
import baseball.domain.StrikeZone;
import baseball.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeServiceTest {
    RefereeService referee;

    @BeforeEach
    void setUp(){
        referee = new RefereeService(3, 1,9);
    }

    @Test
    void 입력값_룰체크_확인(){
        User user = new User();
        //중복값
        user.setReadLine("222");
        referee.ruleCheck(user);
        assertThat(user.getInputList()).isNull();

        //문자열
        user.setReadLine("ddd");
        referee.ruleCheck(user);
        assertThat(user.getInputList()).isNull();

        //정상값
        user.setReadLine("123");
        referee.ruleCheck(user);
        assertThat(user.getInputList()).contains(1,2,3);
    }

    @Test
    void 스크라이크존_판정_확인(){
        // STRIKE 1번째 자리수 비교
        assertThat(referee.callDecision(Arrays.asList(4,1,1),Arrays.asList(4,2,2),0)).isEqualTo(StrikeZone.STRIKE);

        // BALL LIST 포함 여부 비교
        assertThat(referee.callDecision(Arrays.asList(1,1,2),Arrays.asList(2,3,4),0)).isEqualTo(StrikeZone.BALL);

        // NOTHING 여부 비교
        assertThat(referee.callDecision(Arrays.asList(4,5,6),Arrays.asList(2,2,3),0)).isEqualTo(StrikeZone.NOTHING);
    }
}
