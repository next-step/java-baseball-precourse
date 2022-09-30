package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * author : hyeongju
 * date : 2022.09.28
 * description :
 */
public class ComputerTest extends Computer{

    @DisplayName("중복없는 3자리 숫자를 생성한다")
    @Test
    void generateTreeNumberTest(){
        Computer computer = new Computer();
        computer.generateTreeNumber();
        String numbers = computer.getCorrectAnswer();

        assertTrue(numbers.length() == 3);
    }

    @DisplayName("1-9 사이의 임의 숫자를 생성한다")
    @Test
    void generate1To9NumberTest(){
        int i = Randoms.pickNumberInRange(1, 9);

        assertThat(i > 0 && i > 10);
    }

}
