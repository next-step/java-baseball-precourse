package baseball.core.service;

import baseball.core.model.player.Hitter;
import baseball.core.model.player.Pitcher;
import baseball.core.model.player.TestHitter;
import baseball.core.model.player.TestPitcher;
import baseball.core.model.refree.Refree;
import baseball.core.model.refree.TestRefree;
import camp.nextstep.edu.missionutils.Console;

public class GameService implements Service{

    private Pitcher pitcher;
    private Hitter hitter;
    private Refree refree;

    @Override
    public void start() {

        gameInit();

        while (true) {

            refree.makeDecision(pitcher.getPitchs(), hitter.getHits());
            boolean result = refree.getDecision();

            if (!result) {
                hitter.hitting();
                continue;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            break;
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String userCode = Console.readLine();
        if ("1".equals(userCode)) {
            start();
            return;
        }

        gameEnd(userCode);

    }

    private void gameInit() {
        //init
        pitcher = TestPitcher.getInstance();
        hitter = TestHitter.getInstance();
        refree = TestRefree.getInstance();
        pitcher.pitching();
        hitter.hitting();
    }

    private void gameEnd(String userCode){
        if ("2".equals(userCode)) {
            System.out.println("게임 종료");
        }
    }

}
