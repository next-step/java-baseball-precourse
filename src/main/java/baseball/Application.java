package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballViewer baseballViewer = new BaseballViewer();
        BaseballReferee baseballReferee = new BaseballReferee();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        BaseballGameManager baseballGameManager = new BaseballGameManager(baseballViewer, baseballReferee, randomNumberGenerator);
        baseballGameManager.play();
    }
}
