package baseball.tool;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerBaseball extends Baseball {
    public ComputerBaseball() {
        super(Integer.valueOf(pickNumberInRange(1,3)));
    }
}
