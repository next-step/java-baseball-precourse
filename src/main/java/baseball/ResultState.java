package baseball;

public class ResultState {
    private int boll = 0;
    private int strike = 0;

    public void setBoll(int boll) { this.boll = boll; }
    public void setStrike(int strike) { this.strike = strike; }

    public int getBoll() { return this.boll; }
    public int getStrike() { return this.strike; }

    public boolean isNothing() {
        return this.boll == 0 && this.strike == 0;
    }
}
