package baseball.balls;


public class Ball {

    private int position;
    private int number;

    public Ball(int position,int number){
        this.position = position;
        this.number = number;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
}
