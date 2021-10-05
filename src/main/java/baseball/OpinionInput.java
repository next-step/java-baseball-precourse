package baseball;

import nextstep.utils.Console;

public class OpinionInput {
    public int getOpinion() {
        System.out.println(OutputView.GAME_COMMAND);
        String userInput = "";
        while (!checkUserOpinionValidate(userInput)) {
            userInput = Console.readLine();
        }

        return Integer.parseInt(userInput);
    }

    public boolean checkUserOpinionValidate(String opinion) {
        String regexStr = String.format("%s|%s", GameRule.RESET, GameRule.QUIT);
        return opinion.matches(regexStr);
    }


}
