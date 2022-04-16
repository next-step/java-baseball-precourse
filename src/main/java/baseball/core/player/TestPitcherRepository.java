package baseball.core.player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestPitcherRepository implements PitcherRepository{

    public static HashMap<Integer, Integer> pitch;

    TestPitcherRepository(){}

    @Override
    public void pitching() {
        pitch = new LinkedHashMap<>(3);

        for (int pitching = 0; pitching < 3;){
            int ramdom = Randoms.pickNumberInRange(1,9);

            if(!pitch.containsValue(ramdom)){
                pitch.put(pitching, ramdom);
                pitching++;
            }
        }
    }
}


