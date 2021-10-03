package baseball;

import baseball.controller.BaseballController;
import baseball.model.Baseball;
import baseball.view.BaseballView;
import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
		Baseball model = new Baseball();
		BaseballView view = new BaseballView();
		BaseballController controller = new BaseballController(model, view);

    	boolean play = true;
    	while(play) {
    		boolean game = true;
			controller.setComputerNum();

			//play one game
    		while(game) {
    			game = controller.playBaseball();
			}

    		play = controller.keepGoingOrNot();
    	}
    }
}
