package baseball.config;

import baseball.controller.BaseballGame;
import baseball.service.BaseballReferee;
import baseball.service.Referee;
import baseball.view.BaseballView;
import baseball.view.GameView;

public class GameConfig {

    public static GameView baseballView(){
        return new BaseballView();
    }

    public static Referee baseballReferee(){
        return new BaseballReferee();
    }

    public static BaseballGame baseballGame(){
        return new BaseballGame(baseballView(), baseballReferee());
    }
}
