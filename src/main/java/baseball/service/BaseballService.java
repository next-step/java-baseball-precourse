package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.Parse;
import baseball.view.GameMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class BaseballService {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() throws IllegalArgumentException {
        int strike = 0;
        while(strike != 3) {
            play();
            GameMessage.gameCountReturn(computer.getStrikeCount(), computer.getBallCount());
            strike = computer.getStrikeCount();
        }
    }

    public void settingGame() {
        computer.setRandomNumbers(randomItem());
    }

    public void play() {
        computer.resetGame();
        user.setUserNumbers(userInput(3));
        billboardResults(user.getUserNumbers(), computer.getBotNumber());
    }

    public int [] userInput(int SIZE) throws IllegalArgumentException {
        GameMessage.gameStartMessage();
        String userInput = Console.readLine();
        return Parse.userInputParser(userInput, SIZE);
    }

    public static Integer[] randomItem() {
        HashSet<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() < 3){
            randomNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumbers.toArray(new Integer[0]);
    }

    public void billboardResults(int[] userInputItems, Integer[] randomBot) {
        for (int i = 0; i < userInputItems.length; i++) {
            countBillboard(userInputItems, randomBot, i);
        }
    }

    public void countBillboard(int [] userInputItems, Integer [] randomBot, int i) {
        if(userInputItems[i] == randomBot[i])
            strikeCounter();
        if (userInputItems[i] != randomBot[i])
            ballCounter(userInputItems, randomBot[i]);
    }

    public void strikeCounter() {
        computer.strikeCountInc();
    }

    public void ballCounter(int[] userInputItems, int botNumber) {
        for (int i = 0; i < userInputItems.length; i++) {
            if (botNumber == userInputItems[i]) {
                computer.ballCountInc();
            }
        }
    }
}
