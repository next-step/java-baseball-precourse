package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ComputerMachine {

    private List<Integer> randomThreeNumbers;

    public List<Integer> makeThreeNumbers() {
        randomThreeNumbers = new ArrayList<>();
        for (int idx = 0; idx < 3; idx++) {
            randomThreeNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomThreeNumbers;
    }

}
