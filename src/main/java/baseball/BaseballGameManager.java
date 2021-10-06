package baseball;

public class BaseballGameManager {
    private final BaseballViewer baseballViewer;
    private final BaseballReferee baseballReferee;
    private final RandomNumberGenerator randomNumberGenerator;

    public BaseballGameManager(BaseballViewer baseballViewer, BaseballReferee baseballReferee, RandomNumberGenerator randomNumberGenerator) {
        this.baseballViewer = baseballViewer;
        this.baseballReferee = baseballReferee;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {
        String answerNumber = randomNumberGenerator.generateRandomNumber();
    }
}
