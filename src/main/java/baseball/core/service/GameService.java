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

        try {
            gameInit();

            while (true) {

                refree.makeDecision(pitcher.getPitchs(), hitter.getHits());
                boolean result = refree.getDecision();

                if (!result) {
                    hitter.hitting();
                    continue;
                }

                System.out.println("3 strike out!");
                break;
            }

            System.out.print("ENTER THE CODE (RETRY : 0 || GAME-END : 1) : ");
            String userCode = Console.readLine();
            checkRetry(userCode);

            gameEnd(userCode);

        } catch (Exception e) {
            System.err.println(e);
            System.exit(0);
        }


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
        if ("1".equals(userCode)) {
            System.out.println("GAME - END");
            System.exit(0);
        }
    }

    private void checkRetry(String userCode){
        if ("0".equals(userCode)) {
            System.out.print("ENTER CODE(0) GAME RESTART ");
            startGame();
            return;
        }
    }


}
