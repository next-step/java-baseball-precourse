package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * packageName    : baseball
 * fileName       : GameNumberTest
 * author         : BOM
 * date           : 2022-09-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-30        BOM       최초 생성
 * 2022-10-02        BOM       getHintFromUserInputTest메서드 추가
 */
class GameNumberTest {
    static int gameNumberLength;
    static GameNumber gameNumber;
    @BeforeAll
    static void initGameNumberTest(){
        gameNumberLength = 3;
        gameNumber = new GameNumber(gameNumberLength);
    }

    @DisplayName("랜덤한 수의 자리수가 3자리인지, 각 자리수가 서로 다른 숫자인지 확인하는 테스트")
    @Test
    void getRandomNumberStringTest() {

        String gameAnswer = gameNumber.getRandomNumberString();
        assertTrue(gameAnswer.length() == gameNumberLength && gameAnswer.charAt(0) != gameAnswer.charAt(1) && gameAnswer.charAt(0) != gameAnswer.charAt(2) && gameAnswer.charAt(1) != gameAnswer.charAt(2));
    }
    @DisplayName("Input으로 입력받은 수로 올바른 Hint값을 도출하는지 확인하는 테스트")
    @Test
    void getHintFromUserInputTest() {

        String answer = "123";
        String[] inputs = {"456","102","312","123"};

        ArrayList<Hint> hints = new ArrayList<>();
        for(String input : inputs) {
            Hint hint = new Hint();
            gameNumber.getHintFromUserInput(answer,input,hint);
            hints.add(hint);
        }
        for(int i = 0 ; i<=3;i++) {
            Hint hint = hints.get(i);
            if(i ==0)
                assertThat(hint.getStrike()==0&&hint.getBall()==0).isTrue();
            if(i ==1)
                assertThat(hint.getStrike()==1&&hint.getBall()==1).isTrue();
            if(i ==2)
                assertThat(hint.getStrike()==0&&hint.getBall()==3).isTrue();
            if(i ==3)
                assertThat(hint.getStrike()==3&&hint.getBall()==0).isTrue();
        }

    }

}
