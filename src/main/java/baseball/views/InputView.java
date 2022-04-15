package baseball.views;

import baseball.constants.GameView;
import baseball.controllers.BaseballController;
import baseball.domains.Player;

public class InputView {

    public static GameView render(BaseballController controller) {
        System.out.print("숫자를 입력해주세요 : ");
        final Player player = new Player();
        player.play();

        return callApi(player,controller);
    }

    private static GameView callApi(Player player, BaseballController controller) {
        return controller.calculateScore(player);
    }


}
