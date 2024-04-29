package controller;

import domain.Player;
import domain.service.BaseBallService;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseBallController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseBallService baseBallService;

    public BaseBallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.create();
        BaseBallService baseBallService = new BaseBallService(randomNumberGenerator.createRandomNumber());
        inputOneAnswer();
    }

    private void inputOneAnswer() {
        String playerAnswer = inputView.getPlayerAnswer();
        final Player player = Player.create(playerAnswer);
    }
}
