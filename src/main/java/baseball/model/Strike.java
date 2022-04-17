package baseball.model;

public class Strike {
    private int count;

    public Strike() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Boolean computeCount(int user, int computer) {
        if (user == computer && user != -1) {
            this.count++;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean isStrikeExisted() {
        if (this.count == 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
