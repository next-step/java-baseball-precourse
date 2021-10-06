package baseball;

import baseball.controller.BaseballGameManager;
import baseball.controller.BaseballReferee;
import baseball.controller.RandomNumberGenerator;
import baseball.view.BaseballViewer;

public class Application {
    public static void main(String[] args) {
        BaseballViewer baseballViewer = new BaseballViewer();
        BaseballReferee baseballReferee = new BaseballReferee();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        BaseballGameManager baseballGameManager = new BaseballGameManager(baseballViewer, baseballReferee, randomNumberGenerator);
        baseballGameManager.play();
    }
}
