package baseball.player;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UmpireTest{

    @Test
    @DisplayName("스트라이크_3_판정_테스트")
    void 스트라이크_3_판정_테스트(){
        assertTrue(new Umpire().judge(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
        assertFalse(new Umpire().judge(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4)));
    }
}
