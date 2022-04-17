package baseball.core.model.player;

import org.junit.jupiter.api.Test;

public class HitterTest {

    @Test
    void hittingTest(){
        TestHitterRepository h = new TestHitterRepository();
        h.hitting();
    }

}
