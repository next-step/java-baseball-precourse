package domain;

public class Result {

    private final int strikes;
    private final int balls;


    Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    static Result of(int strikes, int balls) {
        return new Result(strikes, balls);
    }


    public boolean isSuccess(int size) {
        return strikes == size;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (strikes != result.strikes) return false;
        return balls == result.balls;
    }

    @Override
    public int hashCode() {
        int result = strikes;
        result = 31 * result + balls;
        return result;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        StringBuilder builder = new StringBuilder();
        if (strikes > 0) {
            builder.append(strikes);
            builder.append("스트라이크 ");
        }
        if (balls > 0) {
            builder.append(balls);
            builder.append("볼");
        }
        return builder.toString();
    }
}
