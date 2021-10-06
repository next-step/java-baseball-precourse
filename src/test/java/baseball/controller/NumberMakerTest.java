package baseball.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NumberMakerTest {
    @Test
    @DisplayName("중복되지 않는 무작위의 숫자 3개를 입력받는지 확인")
    void 무작위숫자(){
        //given
        String numbers = NumberMaker.getBallNumbers();

        //then
        Assertions.assertEquals(3, numbers.length());
    }
}
