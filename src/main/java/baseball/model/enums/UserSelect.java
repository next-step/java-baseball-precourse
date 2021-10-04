package baseball.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserSelect {
    RESTART("1", PlayerStatus.READY),
    EXIT("2", PlayerStatus.END)
    ;

    private final String stringNumber;
    private final PlayerStatus afterPlayerStatus;

    UserSelect(String stringNumber, PlayerStatus afterPlayerStatus) {
        this.stringNumber = stringNumber;
        this.afterPlayerStatus = afterPlayerStatus;
    }

    public PlayerStatus afterPlayerStatus() {
        return afterPlayerStatus;
    }

    private final static Map<String, UserSelect> STRING_NUMBER_CACHE = createCache();

    private static Map<String, UserSelect> createCache() {
        Map<String, UserSelect> map = new HashMap<>();

        for (UserSelect value : values()) {
            map.put(value.stringNumber, value);
        }

        return map;
    }

    public static UserSelect of(String input) {
        return STRING_NUMBER_CACHE.get(input);
    }
}
