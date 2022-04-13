package baseball;

import java.util.List;
import java.util.Objects;

public class CalculateCounts {

    public int strikeCount = 0;
    public int ballCount = 0;

    public void compareEachLists(List<Integer> a, List<String> b) {
        int count = 3;
        for (int i = 0; i < count; i++) {
            Integer a_ = a.get(i);
            Integer b_ = Integer.parseInt(b.get(i));
            calculateStrikes(i, a_, b_);
            calculateBall(i, a, b_);
        }
        printResult();
    }

    private void printResult() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballCount == 0) {
            System.out.printf("%d스트라이크 \n",strikeCount);
            return;
        }
        if (strikeCount == 0) {
            System.out.printf("%d볼 \n", ballCount);
            return;
        }
        System.out.printf("%d볼 %d스트라이크 \n", ballCount, strikeCount);
    }

    public void calculateStrikes(int i, Integer a, Integer b) {
        if (Objects.equals(a, b)) {
            strikeCount += 1;
        }
    }

    public void calculateBall(int i, List<Integer> a, Integer b) {
        if (a.contains(b) && !Objects.equals(a.get(i), b)) {
            ballCount += 1;
        }
    }

}
