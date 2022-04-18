package baseball;

import java.util.List;

public class BaseballCounter implements Counter {

    private final List<Integer> computers;

    public BaseballCounter(BaseballGenerator baseballGenerator) {
        computers = baseballGenerator.Generate();
    }

    @Override
    public void isValid(List<Integer> numbers) {
        if(numbers.size() != 3){
            throw new IllegalArgumentException("3개의 숫자를 입력하세요");
        }
    }

    @Override
    public int getBallCount(List<Integer> numbers) {
        isValid(numbers);

        int ballCnt = 0;
        for (int i = 0; i < numbers.size(); i++) {
            ballCnt = computers.contains(numbers.get(i)) &&
                    computers.get(i) != numbers.get(i) ? ballCnt+1 : ballCnt;
        }

        return ballCnt;
    }

    @Override
    public int getStrikeCount(List<Integer> numbers) {
        return 0;
    }
}
