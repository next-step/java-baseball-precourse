package baseball.core.model.player;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class HitterTest {

    String testStr = "123";//failcase : 1234
    @Test
    void hittingTest(){
        ByteArrayInputStream in = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(in);
        TestHitter hiter = TestHitter.getInstance();
        hiter.hitting();
    }

}
