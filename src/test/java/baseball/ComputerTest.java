package baseball;

import baseball.model.Computer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.lang.reflect.Field;
import java.util.List;

import static baseball.common.Util.convertToList;
import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    @Test
    @DisplayName("Generate baseball number test")
    void generateBaseballNumber() throws Exception{
        Computer computer = new Computer();
        computer.initBaseballNumber();

        Field baseballField = computer.getClass().getDeclaredField("baseballNumber");
        baseballField.setAccessible(true);
        List<?> baseballNumber = (List<?>)baseballField.get(computer);

        assertThat(baseballNumber.size()).isEqualTo(3);
        for (int i = 0; i < baseballNumber.size() - 1; i++) {
            assertThat(baseballNumber.get(i) instanceof Integer).isTrue() ;
            extracted(baseballNumber, i);
        }
    }

    @Test
    @DisplayName("Calculate Score Test")
    void calculateScore() throws Exception{
        List<Integer> correct = convertToList("526");

        Computer computer = new Computer();
        Field baseballField = computer.getClass().getDeclaredField("baseballNumber");
        baseballField.setAccessible(true);
        baseballField.set(computer, correct);

        List<Integer> test1 = convertToList("278");
        List<Integer> test2 = convertToList("276");
        List<Integer> test3 = convertToList("789");
        List<Integer> test4 = convertToList("586");
        List<Integer> test5 = convertToList("526");

        computer.calculateScore(test1);
        assertThat(computer.getStrike()).isEqualTo(0);
        assertThat(computer.getBall()).isEqualTo(1);

        computer.calculateScore(test2);
        assertThat(computer.getStrike()).isEqualTo(1);
        assertThat(computer.getBall()).isEqualTo(1);

        computer.calculateScore(test3);
        assertThat(computer.getStrike()).isEqualTo(0);
        assertThat(computer.getBall()).isEqualTo(0);

        computer.calculateScore(test4);
        assertThat(computer.getStrike()).isEqualTo(2);
        assertThat(computer.getBall()).isEqualTo(0);

        computer.calculateScore(test5);
        assertThat(computer.getStrike()).isEqualTo(3);
        assertThat(computer.getBall()).isEqualTo(0);
    }


    private void extracted(List<?> baseballNumber, int i) {
        for (int j = i + 1; j < baseballNumber.size(); j++) {
            assertThat(!baseballNumber.get(i).equals(baseballNumber.get(j))).isTrue();
        }
    }

}
