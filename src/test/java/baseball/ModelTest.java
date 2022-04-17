package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import baseball.model.Computer;
import baseball.model.Result;
import java.util.ArrayList;
import java.util.List;
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
    void StrikeResultTest(){
        List<Integer> userNumbers = new ArrayList<>(3);
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        Result result = new Result();
        result.createResult(userNumbers, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 3),
                () -> assertThat(result.getBall().getCount() == 0)
        );
    }

    @Test
    void BallResultTest(){
        List<Integer> userNumbers = new ArrayList<>(3);
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(3);
        computerNumbers.add(1);
        computerNumbers.add(2);

        Result result = new Result();
        result.createResult(userNumbers, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 0),
                () -> assertThat(result.getBall().getCount() == 3)
        );
    }

    @Test
    void NothingResultTest(){
        List<Integer> userNumbers = new ArrayList<>(3);
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(4);
        computerNumbers.add(5);
        computerNumbers.add(6);

        Result result = new Result();
        result.createResult(userNumbers, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 0),
                () -> assertThat(result.getBall().getCount() == 0)
        );
    }

    @Test
    void CombinedResultTest_2Strikes_1Nothing(){
        List<Integer> userNumbers = new ArrayList<>(3);
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(4);

        Result result = new Result();
        result.createResult(userNumbers, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 2),
                () -> assertThat(result.getBall().getCount() == 0)
        );
    }

    @Test
    void CombinedResultTest_1Strikes_2Balls(){
        List<Integer> userNumbers = new ArrayList<>(3);
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(3);
        computerNumbers.add(2);

        Result result = new Result();
        result.createResult(userNumbers, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 1),
                () -> assertThat(result.getBall().getCount() == 2)
        );
    }

    @Test
    void CombinedResultTest_1Strike_1Ball(){
        List<Integer> userNumbers = new ArrayList<>(3);
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        List<Integer> computerNumbers = new ArrayList<>(3);
        computerNumbers.add(1);
        computerNumbers.add(5);
        computerNumbers.add(2);

        Result result = new Result();
        result.createResult(userNumbers, computerNumbers);

        assertAll(
                () -> assertThat(result.getStrike().getCount() == 1),
                () -> assertThat(result.getBall().getCount() == 1)
        );
    }
}
