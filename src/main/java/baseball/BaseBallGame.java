package baseball;

import java.util.List;

public class BaseBallGame {

    private final Rule rule;
    private final RandomNumber randomNumber;
    private final Umpires umpires;

    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;

    public BaseBallGame(Rule rule) {
        this.rule = rule;
        this.randomNumber = new RandomNumber(rule);
        this.umpires = new Umpires(rule);
    }

    public void run() {
        boolean play = true;
        while (play) {
            inputPlayerNumbers();
            createComputerNumbers();
            if (umpires.judgementAndIsEndGame(playerNumbers, computerNumbers)) {
                endGame();
                play = replayInput();
            }
        }
    }

    private void inputPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        playerNumbers = Input.inputNumbers();
        if (!rule.validateNumbers(playerNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private void createComputerNumbers() {
        if (computerNumbers == null || computerNumbers.isEmpty()) {
            computerNumbers = randomNumber.getNumbers();
        }
    }

    private void printEndGame() {
        System.out.println(rule.NUMBER_OF_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private boolean replayInput() {
        int number = Input.inputNumber();
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
        if (number == 1) {
            return true;
        }
        return false;
    }

    private void clearPlayerComputerNumbers() {
        playerNumbers.clear();
        computerNumbers.clear();
    }

    private void endGame(){
        printEndGame();
        clearPlayerComputerNumbers();
    }
}
