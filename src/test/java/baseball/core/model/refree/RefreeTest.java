package baseball.core.model.refree;

import baseball.core.model.player.TestHitter;
import baseball.core.model.player.TestPitcher;
import org.junit.jupiter.api.Test;

public class RefreeTest {

    private final String testHits = "456";

    @Test
    void makeDecisionTest(){
        TestPitcher pitcher = TestPitcher.getInstance();
        TestHitter hitter = TestHitter.getInstance();
        TestRefree refree = TestRefree.getInstance();
        pitcher.pitching();
        refree.makeDecision(pitcher.getPitchs(), testHits);
        boolean result = refree.getDecision();
    }
}
