package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgeTest {
    @DisplayName("랜덤 숫자와 사용자가 입력한 숫자가 정확히 맞았을 경우")
    @Test
    public void checkNumbers() {
        ArrayList<Integer> computer = new ArrayList<Integer> () {{
            add(1);
            add(2);
            add(3);
        }};

        ArrayList<Integer> player = new ArrayList<Integer> () {{
            add(1);
            add(2);
            add(3);
        }};

        assertEquals(3, new Judge(computer, player).getGameResult().getStrikeCnt());
    }
}
