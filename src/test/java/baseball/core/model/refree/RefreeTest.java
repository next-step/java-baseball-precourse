package baseball.core.model.refree;

import baseball.core.model.player.TestHitterRepository;
import baseball.core.model.player.TestPitcherRepository;
import org.junit.jupiter.api.Test;

public class RefreeTest {

    private String testHits = "456";

    @Test
    void makeDecisionTest(){
        TestPitcherRepository pitcher = new TestPitcherRepository();
        TestHitterRepository hitter = new TestHitterRepository();
        TestRefreeReository refree = new TestRefreeReository();
        pitcher.pitching();
        refree.makeDecision(pitcher.getPitchs(), testHits);
        boolean result = refree.getDecision();
    }
}
