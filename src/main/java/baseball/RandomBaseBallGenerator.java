package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.commonConstants.MAX_NUMBER;
import static baseball.commonConstants.MIN_NUMBER;

public class RandomBaseBallGenerator implements BallNumberGenerator {

    private List<Integer> ballNumberList = new ArrayList<>();

    @Override
    public List<Integer> generate() {
        while (ballNumberList.size() < 3) {
            ballNumberList.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
            removeDuflicate();
        }

        return ballNumberList;
    }

    private void removeDuflicate() {
        ballNumberList = ballNumberList.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
