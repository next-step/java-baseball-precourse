package baseball.model;

import java.util.List;

public class Ball {
    private int count;

    public Ball() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void computeCount(User user, List<Integer> computer) {
        List<Integer> numbers = user.getNumbers();
        for (int i = 0; i < numbers.size(); i++) {
            computeCount(user, computer, numbers, i);
        }
    }

    private void computeCount(User user, List<Integer> computer, List<Integer> numbers, int i) {
        if (isBall(numbers.get(i), i, computer)) {
            user.checkNumber(numbers.get(i));
        }
    }

    private Boolean isBall(int userNumber, int userIndex, List<Integer> computerNumbers) {
        int index = computerNumbers.indexOf(userNumber);
        if ((userNumber != -1) && (index != -1) && (index != userIndex)) {
            this.count++;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean isBallExisted() {
        if (this.count == 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
