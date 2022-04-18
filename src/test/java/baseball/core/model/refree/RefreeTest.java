package baseball.core.model.refree;

import baseball.core.model.player.TestHitter;
import baseball.core.model.player.TestPitcher;
import org.junit.jupiter.api.Test;

public class RefreeTest {

    private final String testHits = "456";

    @Test
    void makeDecisionTest(){
        TestPitcher pitcher = new TestPitcher();
        TestHitter hitter = new TestHitter();
        TestRefree refree = new TestRefree();
        pitcher.pitching();
        refree.makeDecision(pitcher.getPitchs(), testHits);
        boolean result = refree.getDecision();
    }
}
