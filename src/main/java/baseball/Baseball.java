package baseball;

public class Baseball {

    private char first;
    private char second;
    private char third;


    public Baseball(char first, char second, char third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Baseball(int first, int second, int third) {
        this.first = (char) (first + '0');
        this.second = (char) (second + '0');
        this.third = (char) (third + '0');
    }
    public Baseball() {

    }

    public char getFirst() {
        return first;
    }

    public void setFirst(char first) {
        this.first = first;
    }

    public char getSecond() {
        return second;
    }

    public void setSecond(char second) {
        this.second = second;
    }

    public char getThird() {
        return third;
    }

    public void setThird(char third) {
        this.third = third;
    }


    public void setBallAfterToChar(int firstBall, int secondBall, int thirdBall) {
        this.setFirst((char) (firstBall + '0'));
        this.setSecond((char) (secondBall + '0'));
        this.setThird((char) (thirdBall + '0'));
    }


    @Override
    public String toString() {
        return "Baseball{ " +
                "first : " + first
                +", second : " + second
                + ", third : "  + third
                +" }";
    }

    public void setBall(char firstBall, char secondBall, char thirdBall) {
        this.setFirst( firstBall);
        this.setSecond(secondBall);
        this.setThird(thirdBall);
    }
}
