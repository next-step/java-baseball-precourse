package baseball.modelTest;

import baseball.model.BaseballPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballPlayerTest {
    private BaseballPlayer baseballPlayer;

    @BeforeEach
    void setup(){
        baseballPlayer = new BaseballPlayer("123");
    }

    @Test
    void 사용자벨리데이션패스(){
        assertThat(baseballPlayer.verifyNumber(123));
    }

    @Test
    void 사용자벨리데이션실패_0있는경우(){
        assertThat(!baseballPlayer.verifyNumber(013));
    }

    @Test
    void 사용자벨리데이션실패_자릿수(){
        assertThat(!baseballPlayer.verifyNumber(12345));
    }
}
