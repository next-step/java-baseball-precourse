package baseball.modelTest;

import baseball.model.BaseballCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballCountTest {
    private BaseballCount baseballCount;

    @BeforeEach
    void setup(){
        baseballCount = new BaseballCount(0,0);
        baseballCount.setBalls(0);
        baseballCount.setStrikes(0);
    }

    @Test
    void 낫싱(){
        int playerNumber = 123;
        int computerNumber = 456;
        BaseballCount calculated = baseballCount.calculateCount(playerNumber, computerNumber);
        assertThat(calculated.getStrikes()==0 && calculated.getBalls()==0);
    }

    @Test
    void 스트라이크1볼0(){
        int playerNumber = 123;
        int computerNumber = 145;
        BaseballCount calculated = baseballCount.calculateCount(playerNumber, computerNumber);
        assertThat(calculated.getStrikes()==1 && calculated.getBalls()==0);
    }

    @Test
    void 스트라이크2볼0(){
        int playerNumber = 123;
        int computerNumber = 125;
        BaseballCount calculated = baseballCount.calculateCount(playerNumber, computerNumber);
        assertThat(calculated.getStrikes()==2 && calculated.getBalls()==0);
    }

    @Test
    void 스트라이크3볼0(){
        int playerNumber = 123;
        int computerNumber = 123;
        BaseballCount calculated = baseballCount.calculateCount(playerNumber, computerNumber);
        assertThat(calculated.getStrikes()==3 && calculated.getBalls()==0);
    }

    @Test
    void 스트라이크1볼1(){
        int playerNumber = 132;
        int computerNumber = 125;
        BaseballCount calculated = baseballCount.calculateCount(playerNumber, computerNumber);
        assertThat(calculated.getStrikes()==1 && calculated.getBalls()==1);
    }

    @Test
    void 스트라이크1볼2(){
        int playerNumber = 132;
        int computerNumber = 123;
        BaseballCount calculated = baseballCount.calculateCount(playerNumber, computerNumber);
        assertThat(calculated.getStrikes()==1 && calculated.getBalls()==2);
    }

}
