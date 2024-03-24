package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.service.JudgeService;
import baseball.ui.Input;
import baseball.ui.Output;

public class GameController {
    private final JudgeService judgeService = new JudgeService();
    private final Input input = new Input();
    private final Computer computer = new Computer();
    private Baseball computerNumbers;

    public void start() {
       do {
           computerNumbers = computer.generateRandomNumbers();
           run();
       } while (playAgain() == 1);
       input.close();
   }

   private void run() {
       Result result;
       do {
           Baseball userNumbers = generateUserNumbers();
           result = judgeService.judge(computerNumbers, userNumbers);
           printResult(result);
       } while (!result.isOver);

       Output.printMessage(Output.GAME_ASK_MESSAGE);
   }

    private void printResult(Result result) {
        Output.printMessage(result.getResultMessage());
        if (result.isOver) {
            Output.printMessage(Output.GAME_END_MESSAGE);
        }
    }

    private int playAgain() {
        int userInput = 0;
        try {
            userInput = Integer.parseInt(input.getInput());
            if (userInput != 1 && userInput != 2) {
                throw new IllegalArgumentException(Output.PLAY_AGAIN_WRONG_INPUT_MESSAGE);
            }
            return userInput;
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(Output.PLAY_AGAIN_WRONG_INPUT_MESSAGE);
            return playAgain();
        }
    }

   private Baseball generateUserNumbers() {
       try {
           String userInput = input.getUserInput();
           return new Baseball(userInput);
       } catch (IllegalArgumentException e) {
           Output.printExceptionMessage(e.getMessage());
           return generateUserNumbers();
       }
   }

}
