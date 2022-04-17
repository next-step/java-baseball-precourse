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
    private static final String KEEP_GOING = "y";
    private static final String END_GAME = "n";

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
            List<Integer> gameAnswer = Randoms.pickUniqueNumbersInRange(NUMBER_START,NUMBER_END, ANSWER_LENGTH);
            answerService.resetGameAnswer(gameAnswer);
            start();
        }
    }

    private boolean restartAnswer(String input) {
        return input.equals(KEEP_GOING) || input.equals(END_GAME);
    }
}
