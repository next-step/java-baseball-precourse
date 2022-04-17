package baseball.game;

import baseball.answer.Answer;
import baseball.answer.AnswerService;
import baseball.input.InputService;
import baseball.output.OutPutService;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseBallGame implements Game{

    private final InputService inputService;
    private final OutPutService outPutService;
    private final AnswerService answerService;
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 9;
    private static final int ANSWER_LENGTH = 3;

    public BaseBallGame() {
        List<Integer> gameAnswer = Randoms.pickUniqueNumbersInRange(NUMBER_START,NUMBER_END, ANSWER_LENGTH);
        inputService = new InputService();
        outPutService = new OutPutService();
        answerService = new AnswerService(gameAnswer);
    }

    public void start() {
        Answer answer;
        do {
            outPutService.printGameMessage();
            List<Integer> input = inputService.getInput();
            answer = answerService.result(input);
            outPutService.printHintMessage(answer.getStrike(), answer.getBall());
        } while (answer.isStrikeOut());
        askRestart();
    }

    private void askRestart() {
        outPutService.printRestartMessage();
        String input;
        do {
            input = Console.readLine();
        } while (restartAnswer(input));

        if(input.equalsIgnoreCase("y")){
            List<Integer> gameAnswer = Randoms.pickUniqueNumbersInRange(NUMBER_START,NUMBER_END, ANSWER_LENGTH);
            answerService.resetGameAnswer(gameAnswer);
            start();
        }
    }

    private boolean restartAnswer(String input) {
        return input.equals("y") || input.equals("n");
    }
}
