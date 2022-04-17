package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.controller.InputController;
import baseball.model.Result;
import baseball.model.User;
import baseball.view.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static InputController inputController;
    private static Console console;

    public static void main(String[] args) {
        init();
        List<Integer> computerNumbers = initComputer();
        while (true) {
            String numbers = inputController.inputNumbers();
            Result result = getResult(numbers, computerNumbers);
            console.displayResult(result);
            if (is3Strikes(result, computerNumbers)) {
                break;
            }
        }
    }

    private static List<Integer> initComputer() {
        List<Integer> computerNumbers = new ArrayList<>(3);
        createComputerNumbers(computerNumbers);
        return computerNumbers;
    }

    private static void createComputerNumbers(List<Integer> computerNumbers) {
        computerNumbers.clear();
        while (computerNumbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    private static boolean is3Strikes(Result result, List<Integer> computerNumbers) {
        if (result.is3Strikes()) {
            if (isGameEnding(computerNumbers)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isGameEnding(List<Integer> computerNumbers) {
        console.gameEnd();
        Integer options = inputController.inputOptions();
        if (options == 2) {
            return true;
        }
        if (options == 1) {
            createComputerNumbers(computerNumbers);
        }
        return false;
    }

    private static Result getResult(String numbers, List<Integer> computerNumbers) {
        User user = new User(numbers);
        Result result = new Result();
        result.createResult(user, computerNumbers);
        return result;
    }

    private static void init() {
        inputController = new InputController();
        console = new Console();
    }
}
