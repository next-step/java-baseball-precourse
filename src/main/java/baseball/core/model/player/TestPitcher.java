package baseball.core.model.player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestPitcher implements Pitcher {

    private static TestPitcher testPitcher = null;
    public static HashMap<Integer, Integer> pitch;

    private TestPitcher() {}

    public synchronized static TestPitcher getInstance() {
        if (testPitcher == null)
            testPitcher = new TestPitcher();
        return testPitcher;
    }


    @Override
    public void pitching() {
        pitch = new LinkedHashMap<>(3);

        for (int pitching = 0; pitching < 3; ) {
            int ramdom = Randoms.pickNumberInRange(1, 9);

            if (!pitch.containsValue(ramdom)) {
                pitch.put(pitching, ramdom);
                pitching++;
            }
        }
    }

    @Override
    public HashMap<Integer, Integer> getPitchs() {
        return pitch;
    }
}


