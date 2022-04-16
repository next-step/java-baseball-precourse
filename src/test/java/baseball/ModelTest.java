package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Computer;
import org.junit.jupiter.api.Test;

public class ModelTest {

    @Test
    void computerModelTest(){
        Computer computer = new Computer();
        assertSimpleTest(
                () -> assertThat(computer.getNumbers().size() == 3)
        );

        for(int i=0; i<computer.getNumbers().size()-1; i++){
            for(int j=i+1; j<computer.getNumbers().size(); j++){
                assertThat(computer.getNumbers().get(i).intValue() != computer.getNumbers().get(j).intValue());
            }
        }
    }


    @Test
    void ResultTest(){

    }
}
