package baseball.core.service;

import baseball.core.model.player.TestHitterRepository;
import baseball.core.model.player.TestPitcherRepository;
import baseball.core.model.refree.TestRefreeReository;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    private TestPitcherRepository pitcher;
    private TestHitterRepository hitter;
    private TestRefreeReository refree;

    public void startGame() {

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
            startGame();
            return;
        }

        gameEnd(userCode);

    }

    private void gameInit() {
        //init
        pitcher = new TestPitcherRepository();
        hitter = new TestHitterRepository();
        refree = new TestRefreeReository();
        pitcher.pitching();
        hitter.hitting();
    }

    private void gameEnd(String userCode){
        if ("2".equals(userCode)) {
            System.out.println("게임 종료");
            return;
        }
    }

}
