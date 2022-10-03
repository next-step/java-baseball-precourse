package baseball;

import baseball.constants.ResultMessage;
import baseball.input.InputView;
import baseball.input.bean.Player;
import baseball.result.*;
import baseball.result.bean.Computer;
import baseball.result.bean.Result;

public class BaseballController {
    private InputView inputView;
    private Player player;
    private Computer computer;
    private Converter converter;
    private ComputerNumberGenerator computerNumberGenerator;
    private ResultView resultView;
    private ResultMaker resultMaker;
    private Result result;

    public BaseballController() {
        this.inputView = new InputView();
        this.player = new Player();
        this.converter = new Converter();
        this.computerNumberGenerator = new ComputerNumberGenerator();
        this.resultMaker = new ResultMaker();
        this.resultView = new ResultView();
    }

    public void playGame() {
        this.computer = this.computerNumberGenerator.generateComputerNumber();
        this.player.setNumbers(this.inputView.scanNumber());
        this.resultMaker.setResult(new Result(
                new Counter(this.player, this.computer)));
        this.result = this.resultMaker.getResult();

        while(!this.result.isGameOver()) {
            this.resultView.printResult(this.result);
            this.player.setNumbers(this.inputView.scanNumber());
            this.resultMaker.setResult(new Result(
                    new Counter(this.player, this.computer)));
            this.result = this.resultMaker.getResult();
        }
        System.out.println(ResultMessage.GAME_OVER);
    }


    public boolean isRestartGame() {
        String inputRestartCode = this.inputView.scanRestartGame();
        return this.resultView.resultRestartGame(inputRestartCode);
    }


    public void endGame() {
        System.exit(0);
    }
}
