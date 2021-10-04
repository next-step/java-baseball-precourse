package baseball.domain;

public class Ball {
    public static boolean isBetween1And(int num) {
        if (1 <= num && num <= 9) {
            return true;
        } else {
            return false;
        }

    }
}
