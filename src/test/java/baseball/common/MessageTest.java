package baseball.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * author : hyeongju
 * date : 2022.09.28
 * description :
 */
public class MessageTest {

    @Test
    @DisplayName("enum message가 정상적으로 출력되는지 테스트한다")
    void getEnumMessageTest(){
        String msgInputNumbersMessage = Message.MSG_INPUT_NUMBERS.getMessage();
        assertEquals(msgInputNumbersMessage,"숫자를 입력해주세요 : ");
    }

}
