package baseball.domain;

import baseball.interfaces.dto.BallCountDTO;

public class GameService {
    private Game game;
    private IRandomNumberPicker randomNumberPicker;

    public GameService() {
        this.randomNumberPicker = new RandomNumberPickerImpl();
    }

    public void playBall() {
        this.game = new Game(this.randomNumberPicker);
    }

    public BallCountDTO submit(int[] answer) {
        BallCount ballCount = this.game.check(answer);

        return BallCountDTO.fromModel(ballCount);


    }


}
