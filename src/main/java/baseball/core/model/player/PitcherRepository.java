package baseball.core.model.player;

import java.util.HashMap;

public interface PitcherRepository {

    void pitching();

    HashMap<Integer, Integer> getPitchs();
}
