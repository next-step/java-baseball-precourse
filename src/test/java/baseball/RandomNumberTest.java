package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

    @Test
    @DisplayName("서로 다른 3가지의 수 생성")
    void getNumbers(){

        // given
        RandomNumber randomNumber = new RandomNumber(new Rule());

        // when
        List<Integer> numbers =  randomNumber.getNumbers();
        System.out.println(numbers);

    }

}