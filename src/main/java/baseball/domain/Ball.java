package baseball.domain;

public class Ball {

    private int pos;
    private int number;

    public Ball() {

    }

    public Ball(int pos, int number) {
        this.pos = pos;
        this.number = number;
    }

    public static boolean isBetween1And(int num) {
        if (1 <= num && num <= 9) {
            return true;
        } else {
            return false;
        }

    }

    public int getPos() {
        return pos;
    }

    public  int getNumber() {
        return number;
    }
}
