package baseball.domain;

import baseball.common.Constants;
import baseball.common.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public Balls answer;

    public Computer() {
        answer = new Balls();
    }

    public String getAnswerToString() {
        return answer.toString();
    }

    public int getAnswerToInt() {
        return answer.toInteger();
    }

    public Balls getAnswer() {
        return answer;
    }

    public void generateBaseballNumber() {
        List<Integer> numbers = NumberGenerator.numberGenerate();
        answer = new Balls(settingAnswer(numbers));
    }

    public List<Ball> settingAnswer(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        while (balls.size() < Constants.BALLS_SIZE) {
            balls.add(new Ball(balls.size() + 1, numbers.get(balls.size())));
        }
        return balls;
    }

}
