package baseball;

import java.util.HashSet;
import java.util.regex.Pattern;

public class GameBrokerController {

    public boolean isValidInput(String s) {
        Pattern pattern = Pattern.compile("^[1-9]+$");
        boolean isNumeric = pattern.matcher(s).matches();
        boolean isValidLength = s.length() == Config.GAME_COUNT;

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(s.charAt(i));
        }

        return isNumeric && isValidLength && set.size() == Config.GAME_COUNT;
    }

    public int[] parseString(String s) {
        int[] result = new int[Config.GAME_COUNT];

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            result[i] = (Character.getNumericValue(word));
        }
        return result;
    }

    public GameResult[] run(String input) {
        if (!this.isValidInput(input)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다. 프로그램을 종료합니다");
        }

        int[] userInputArray = this.parseString(input);
        GameBotModel bot = GameBotModel.getInstance();
        if (bot.isCompleted()) {
            bot.initialize();
        }
        return bot.checkAnswer(userInputArray);
    }

    public boolean willContinue(String s) {
        Pattern pattern = Pattern.compile("^[1-9]$");
        boolean isValidInput = pattern.matcher(s).matches();
        int option = Integer.parseInt(s);
        if (!isValidInput || (option != 1 && option != 2)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다. 프로그램을 종료합니다.");
        }
        return option == 1;
    }

}
