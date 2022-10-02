package baseball.game;

import baseball.computer.Computer;
import baseball.computer.ScoreBagValidator;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private boolean correct = false;

    private final Computer computer;
    private final ScoreBagValidator scoreBagValidator = new ScoreBagValidator();

    public Game() {
        this.computer = new Computer();
    }

    public void startGame() {
        while (!correct) {
            System.out.println("숫자를 입력해주세요");
            String input = Console.readLine();
            scoreBagValidator.valid(input);
            correct = computer.check(convert(input));
        }
    }

    private int[] convert(String input) {
        char[] inputCharArray = input.toCharArray();
        int[] result = new int[inputCharArray.length];
        for (int i = 0; i < inputCharArray.length; i++) {
            result[i] = Integer.parseInt(String.valueOf(inputCharArray[i]));
        }
        return result;
    }
}
