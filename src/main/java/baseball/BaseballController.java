package baseball;

public class BaseballController {
    public static final boolean GAME_IS_ENDED = true;
    public static final boolean GAME_IS_NOT_ENDED = false;
    public static final String RESTART_GAME = "1";
    public static final String END_GAME = "2";
    BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public boolean playGame(String answer, String input) {
        baseballService.validateNumber(input);
        Score score = baseballService.countScore(answer, input);
        System.out.println(score);
        if (baseballService.isGameEnded(score)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return GAME_IS_ENDED;
        }
        return GAME_IS_NOT_ENDED;
    }

    public String makeAnswer() {
        return baseballService.generateRandomThreeDigitNumber();
    }

    public boolean checkRestart(String input) {
        if (input.equals(RESTART_GAME)) {
            return true;
        }
        if (input.equals(END_GAME)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
