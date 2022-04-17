package baseball.game;

import baseball.answer.Answer;
import baseball.answer.AnswerService;
import baseball.input.InputService;
import baseball.output.OutPutService;
import baseball.util.RandomUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame implements Game{

    private final InputService inputService;
    private final OutPutService outPutService;
    private final AnswerService answerService;
    private static final String KEEP_GOING = "1";
    private static final String END_GAME = "2";

    public BaseBallGame() {
        inputService = new InputService();
        outPutService = new OutPutService();
        answerService = new AnswerService(RandomUtil.create());
    }

    public void start() {
        Answer answer;
        do {
            outPutService.printGameMessage();
            List<Integer> input = inputService.getInput();
            answer = answerService.result(input);
            outPutService.printHintMessage(answer.getStrike(), answer.getBall());
        } while (answer.isNotStrikeOut());
        askRestart();
    }

    private void askRestart() {
        outPutService.printRestartMessage();
        String input;
        do {
            input = Console.readLine();
        } while (restartAnswer(input));

        if(input.equalsIgnoreCase(KEEP_GOING)){
            answerService.resetGameAnswer(RandomUtil.create());
            start();
        }

        outPutService.printEndMessage();
    }

    private boolean restartAnswer(String input) {
        return !(input.equals(KEEP_GOING) || input.equals(END_GAME));
    }
}
