package baseball;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayResult {

    private static LinkedHashMap<Status, Integer> statusMap = new LinkedHashMap<>();

    public PlayResult() {
        statusMap.clear();
    }

    public static PlayResult of() {
        return new PlayResult();
    }

    public void reulstCount(Status ballStatus) {
        if (!statusMap.containsKey(ballStatus)) {
            statusMap.put(ballStatus, 1);
            return;
        }
        statusMap.put(ballStatus, statusMap.get(ballStatus) + 1);
    }

    public int strikeCount() {
        return statusMap.get(Status.STRIKE) != null ? statusMap.get(Status.STRIKE) : 0;
    }

    public int ballCount() {
        return statusMap.get(Status.BALL);
    }

    public Map<Status, Integer> resultGame() {
        removeNothing();
        return Collections.unmodifiableMap(statusMap);
    }

    private void removeNothing() {
        if (statusMap.get(Status.NOTHING) != null && statusMap.get(Status.NOTHING) != 3) {
            statusMap.remove(Status.NOTHING);
        }
    }
}


