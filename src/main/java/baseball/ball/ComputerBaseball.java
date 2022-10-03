package baseball.ball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class ComputerBaseball extends Baseball {
    private final Integer MIN_NUM = 111;
    private final Integer MAX_NUM = 999;
    private final Integer COUNT = 1;

    public ComputerBaseball() {
        super();
        List<Integer> value = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, COUNT);
        if (value.isEmpty()) {
            throw new RuntimeException();
        }
        setBall(String.valueOf(value.get(0)));
    }
}
