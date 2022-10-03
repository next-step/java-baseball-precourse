package baseball.ui;

import static java.lang.System.out;

import baseball.common.Constants;
import baseball.common.PlayBaseStatus;
import baseball.model.UserAnswerRequest;
import baseball.model.PlayResult;
import baseball.model.UserPlayRequest;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

public class BaseView {
    private final BaseballService baseballService;

    public BaseView(BaseballService service) {
        this.baseballService = service;
    }

    /**
     * play baseball game
     *
     * @throws IllegalArgumentException when there is a problem with the user's input
     */
    public void playBall() throws IllegalArgumentException {
        while (true) {
            out.print(Constants.REQUEST);
            PlayResult response = baseballService.play(UserAnswerRequest.valueOf(Console.readLine()));
            out.println(response.getAnswer());
            if (response.getStatus() == PlayBaseStatus.OVER && !playAgain()) {
                break;
            }
        }
    }

    /**
     * Checks whether the baseball game is in progress.
     *
     * @throws IllegalArgumentException when there is a problem with the user's input
     */
    private boolean playAgain() throws IllegalArgumentException {
        out.println(Constants.MISSION_COMPLETE);
        out.println(Constants.REPLY_REQUEST);
        UserPlayRequest userPlayRequest = UserPlayRequest.valueOf(Console.readLine());
        return baseballService.playAgain(userPlayRequest);
    }
}
