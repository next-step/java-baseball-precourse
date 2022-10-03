package baseball.view;

import baseball.controller.ContinueKey;
import baseball.controller.MainController;
import baseball.domain.BaseballNumbers;
import baseball.domain.Hint;
import camp.nextstep.edu.missionutils.Console;

public class MainView {
    
    public static void baseballNumbersForm(MainController mainController) {
        printQuestionNumbers();
        
        BaseballNumbers input = BaseballNumbers.from(Console.readLine());
        mainController.requestHint(input);
    }

    public static void printHint(Hint hint) {
        System.out.println(hint.getMessage());
    }

    public static void continueForm(MainController mainController) {
        printAnswer();
        printQuit();
        
        ContinueKey input = continueKeyForm();
        mainController.requestContinue(input);
    }

    public static void printQuit() {
        System.out.println(PrintMessage.INFORMATION_QUIT.getMessage());
    }

    private static ContinueKey continueKeyForm() {
        printContinue();
        
        ContinueKey continueKey = null;

        while (continueKey == null) {
            continueKey = inputContinueKey();
        }

        return continueKey;
    }
    
    private static ContinueKey inputContinueKey() {
        ContinueKey result = null;

        try {
            result = ContinueKey.from(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return result;
    } 

    private static void printContinue() {
        System.out.println(
                PrintMessage.QUESTION_CONTINUE.getMessage(ContinueKey.convertEnumToKeys().toArray()));
    }

    private static void printQuestionNumbers() {
        System.out.print(PrintMessage.QUESTION_BASEBALL_NUMBERS.getMessage());
    }

    private static void printAnswer() {
        System.out.print(PrintMessage.INFORMATION_ANSWER.getMessage(BaseballNumbers.NUMBER_SIZE));
    }
}
