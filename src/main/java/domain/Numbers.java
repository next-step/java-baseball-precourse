package domain;

import java.util.List;
import java.util.function.IntFunction;

public class Numbers {

    private final List<Integer> nums;

    @Deprecated
    public Numbers(int first, int second, int third) {
        nums = List.of(first, second, third);
    }

    public Numbers(List<Integer> nums) {
        this.nums = nums;
    }

    public Result matchWith(Numbers numbers) {
        if (getSize() != numbers.getSize()) {
            throw new RuntimeException("같은 개수의 숫자만 평가할 수 있습니다 (좌변: " + getSize() + ", 우변: " + numbers.getSize() + ")");
        }

        int strikes = calculateStrikes(this, numbers);
        int balls = calculateBalls(this, numbers);

        return Result.of(strikes, balls);
    }

    private static int calculateStrikes(Numbers left, Numbers right) {
        int strikes = 0;

        for (int i = 0; i < left.getSize(); i++) {
            if (left.getNum(i) == right.getNum(i)) strikes++;
        }

        return strikes;
    }

    private static int calculateBalls(Numbers left, Numbers right) {
        int balls = 0;

        for (int i = 0; i < left.getSize(); i++) {
            if (isBallCount(i, left, right)) balls++;
        }

        return balls;
    }

    private static boolean isBallCount(int leftIdx, Numbers left, Numbers right) {
        for (int rightIdx = 0; rightIdx < left.getSize(); rightIdx++) {
            if (leftIdx == rightIdx) continue;
            if (left.getNum(leftIdx) == right.getNum(rightIdx)) return true;
        }
        return false;
    }

    public int getSize() {
        return nums.size();
    }

    public int getNum(int idx) {
        return nums.get(idx);
    }

    @Deprecated
    public int getFirst() {
        return getNum(0);
    }

    @Deprecated
    public int getSecond() {
        return getNum(1);
    }

    @Deprecated
    public int getThird() {
        return getNum(2);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "nums=" + nums +
                '}';
    }
}
