
package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static final int gameNumberLength = 3;


    public static void main(String[] args) {
        GameNumber gameNumber = new GameNumber(gameNumberLength);
        InputValidation inputValidation = new InputValidation(gameNumberLength);
        View view = new View();
        Hint hint = new Hint();
        String gameStatus = "1";
        while (gameStatus.equals("1")) {
            runGame(hint, view, inputValidation, gameNumber);
            gameStatus = askNewGame(view, inputValidation);
        }
    }

    /*게임을 진행시키는 메서드*/
    public static void runGame(Hint hint, View view, InputValidation inputValidation, GameNumber gameNumber) {
        hint.resetCounts();
        String gameAnswerNumber = gameNumber.getRandomNumberString();
        String input;
        while (hint.getStrike() < gameNumberLength) {
            hint.resetCounts();
            input = getUserGuess(view,inputValidation);
            gameNumber.getHintFromUserInput(input, gameAnswerNumber, hint);
            view.printResultOfGuess(hint.getBall(), hint.getStrike());
        }
    }
    /*사용자에게 추측값을 받아오는 메서드*/
    public static String getUserGuess(View view, InputValidation inputValidation) {
        view.printGameInterface("숫자입력요청");
        String input = readLine();
        inputValidation.validateInputNumberFromUser(input);
        return input;
    }
    /*재게임 의사를 묻고 진행시키는 메서드*/
    public static String askNewGame(View view, InputValidation inputValidation) {
        view.printGameInterface("정답맞춤");
        String input = readLine();
        inputValidation.validateRegameInputFromUser(input);
        return input;

    }
}

