package domain;

public class Numbers {

    private final int First;
    private final int Second;
    private final int Third;

    public Numbers(int first, int second, int third) {
        First = first;
        Second = second;
        Third = third;
    }

    public Result matchWith(Numbers numbers) {
        int strikes = calculateStrikes(this, numbers);
        int balls = calculateBalls(this, numbers);

        return Result.of(strikes, balls);
    }

    private static int calculateStrikes(Numbers left, Numbers right) {
        int strikes = 0;

        if (left.First == right.First) strikes++;
        if (left.Second == right.Second) strikes++;
        if (left.Third == right.Third) strikes++;

        return strikes;
    }

    private static int calculateBalls(Numbers left, Numbers right) {
        int balls = 0;

        if (left.First == right.Second || left.First == right.Third) balls++;
        if (left.Second == right.First || left.Second == right.Third) balls++;
        if (left.Third == right.First || left.Third == right.Second) balls++;

        return balls;
    }

    public int getFirst() {
        return First;
    }

    public int getSecond() {
        return Second;
    }

    public int getThird() {
        return Third;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "First=" + First +
                ", Second=" + Second +
                ", Third=" + Third +
                '}';
    }
}
