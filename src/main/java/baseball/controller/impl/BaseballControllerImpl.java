package baseball.controller.impl;

import baseball.controller.BaseballController;
import baseball.controller.BaseballGameUserInputValidator;
import baseball.model.BaseballGameModel;
import baseball.model.BaseballGameRule;
import baseball.model.InningResultData;
import baseball.veiw.BaseballCuiView;
import baseball.veiw.impl.BaseballCuiViewImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballControllerImpl implements BaseballController {
    BaseballGameModel baseballGameModel;

    BaseballCuiView baseballCuiView = new BaseballCuiViewImpl();

    @Override
    public void start() {
        boolean restartCommand = true;
        while(restartCommand) {
            startGame();
            baseballCuiView.printRestartQuestion();
            int command = readRestartCommand();
            restartCommand = isRestartCommand(command);
        }
    }

    private void startGame() {
        baseballGameModel = new BaseballGameModel(makeCorrectNumberList());

        while (!baseballGameModel.isEndedInning()) {
            baseballCuiView.printInputNumber();
            InningResultData result = baseballGameModel.playOneInning(
                    readNumberList()
            );
            baseballCuiView.printInningResult(result);
        }
        baseballCuiView.printEnding(BaseballGameRule.PITCHING_COUNT);
    }

    private List<Integer> readNumberList() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        BaseballGameUserInputValidator.validateUserNumberInput(input, BaseballGameRule.PITCHING_COUNT);
        return convertStringToIntegerList(input);
    }

    private int readRestartCommand() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        BaseballGameUserInputValidator.validateUserNumberInput(input, 1);
        int command = convertStringToIntegerList(input).get(0);
        BaseballGameUserInputValidator.validateRestartCommand(command);
        return command;
    }

    private boolean isRestartCommand(int command) {
        return (command == 1);
    }

    private List<Integer> convertStringToIntegerList(String str) {
        List<Integer> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
        return result;
    }

    private int generateRandomNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(BaseballGameRule.MINIMUM_NUMBER, BaseballGameRule.MAXIMUM_NUMBER);
    }

    private List<Integer> makeCorrectNumberList() {
        Set<Integer> correctNumberSet = new HashSet<>();
        while (correctNumberSet.size() != BaseballGameRule.PITCHING_COUNT) {
            correctNumberSet.add(generateRandomNumber());
        }
        return new ArrayList<>(correctNumberSet);
    }
}
