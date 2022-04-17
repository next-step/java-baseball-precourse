package baseball.core.model.player;

import org.junit.jupiter.api.Test;

public class HitterTest {

    @Test
    void hitterTest(){
        TestHitterRepository h = new TestHitterRepository();
        h.hitting();
    }

}
