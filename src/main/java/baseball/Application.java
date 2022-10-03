package baseball;

import baseball.model.PlayBase;
import baseball.service.BaseballService;
import baseball.ui.BaseView;

public class Application {
    public static void main(String[] args) {
        PlayBase playBase = new PlayBase();
        BaseballService service = new BaseballService(playBase);
        BaseView baseView = new BaseView(service);
        baseView.playBall();
    }
}
