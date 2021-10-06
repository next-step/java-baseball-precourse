package baseball;

import nextstep.utils.Console;

/**
 * Name : BaseBallGame <br/>
 * Description : 야구 게임 객체
 */
public class BaseBallGame {
    public static final int DEFAULT_LENGTH = 3;

    private RandomNumberGenerator randomNumberGenerator;
    private InputNumberValidator inputNumberValidator;
    private BaseBallGameNumberComparator baseBallGameNumberComparator;
    private BaseBallResultPrinter baseBallResultPrinter;

    public BaseBallGame(int maxLength) {
        randomNumberGenerator = new RandomNumberGenerator(maxLength);
        inputNumberValidator = new InputNumberValidator();
        baseBallGameNumberComparator = new BaseBallGameNumberComparator(maxLength);
        baseBallResultPrinter = new BaseBallResultPrinter();
    }

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(DEFAULT_LENGTH);
        baseBallGame.run();
    }

    private void run() {
        String randomGenerated = randomNumberGenerator.generateNumbers();
        int[] result;

        do {
            String userInputNumber = inputNumber();
            result = compareNumber(randomGenerated, userInputNumber);
        }while (result[0] != 3);
        isGameEnd(result);
    }

    private void isGameEnd(int[] result) {
        if(result[0] == 3) {
            setGameFlag();
        }
    }

    private void setGameFlag() {
        System.out.println("게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(Console.readLine().equals("1")) {
            run();
        }
    }

    private int[] compareNumber(String randomGenerated, String userInputNumber) {
        int[] result;
        result = baseBallGameNumberComparator.getBaseBallGameResult(randomGenerated, userInputNumber);
        baseBallResultPrinter.print(result);
        return result;
    }

    private String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        return validateInputNumber(inputNumber);
    }

    private String validateInputNumber(String inputNumber) {
        if(inputNumberValidator.validate(inputNumber))
            return inputNumber;
        return inputNumber();
    }
}
