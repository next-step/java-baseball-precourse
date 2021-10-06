package baseball;

import nextstep.utils.Console;

/**
 * Name : BaseBallGame <br/>
 * Description : 야구 게임 클래스
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

    /**
     * 야구 게임 실행
     */
    private void run() {
        String randomGenerated = randomNumberGenerator.generateNumbers(); //난수 생성
        int[] result;

        do {
            String userInputNumber = inputNumber();
            result = compareNumber(randomGenerated, userInputNumber);
        }while (result[0] != BaseBallGame.DEFAULT_LENGTH);
        checkGameEnd(result); //게임 종료 여부 체크
    }


    /**
     * 3 스트라이크 완료 후 게임 종료 여부 체크
     */
    private void checkGameEnd(int[] result) {
        if(result[0] == BaseBallGame.DEFAULT_LENGTH) {
            setGameFlag();
        }
    }

    /**
     * 게임 계속/종료 여부 입력
     */
    private void setGameFlag() {
        System.out.println("게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(Console.readLine().equals("1")) {
            run(); //새로 시작시 야구게임 재실행
        }
    }

    /**
     * 랜덤 생성 난수와 사용자 입력값 비교
     */
    private int[] compareNumber(String randomGenerated, String userInputNumber) {
        int[] result;
        result = baseBallGameNumberComparator.getBaseBallGameResult(randomGenerated, userInputNumber);
        baseBallResultPrinter.print(result);
        return result;
    }

    /**
     * 게임 사용자 숫자 입력
     */
    private String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        return validateInputNumber(inputNumber);
    }

    /**
     * 게임 사용자 입력값 검증
     */
    private String validateInputNumber(String inputNumber) {
        if(inputNumberValidator.validate(inputNumber))
            return inputNumber;
        return inputNumber();
    }
}
