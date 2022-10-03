package baseball.ball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserBaseball extends Baseball {
    public UserBaseball(String ball) {
        super(ball);
    }
    public UserBaseball() {
        super();
    }

    public void createBall(){
        String userInput = readLine();
        this.setBall(userInput);
    }
}
