package baseball.referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * author : hyeongju
 * date : 2022.09.29
 * description :
 */
public class RefereeTest {

    Referee referee = new Referee();

    @DisplayName("낫싱 판단 : 일치하는 숫자가 하나도 없을 때")
    @Test
    void nothingTest(){
        referee.judge("123", "456");
    }

    @DisplayName("스트라이크 판단 : 같은 수가 같은 자리에 있으면")
    @Test
    void strikeTest(){
        referee.judge("123", "145");
    }

    @DisplayName("3스트라이크 : 모두 맞췄으면")
    @Test
    void successTest(){
        referee.judge("123", "123");
    }

    @DisplayName("볼 판단 : 다른 자리에 있으면")
    @Test
    void ballTest(){
        referee.judge("123", "345");
    }

    @DisplayName("1볼 판단")
    @Test
    void oneBallTest(){
        referee.judge("123", "345");
    }

    @DisplayName("1볼 1 스트라이크 판단")
    @Test
    void oneBallOneStrikeTest(){
        referee.judge("123", "325");
    }

}
