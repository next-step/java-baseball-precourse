package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public enum ContinueKey {

    START("1"),
    QUIT("2");

    private final String key;
    
    private ContinueKey(String key) {
        this.key = key;
    }

    public static ContinueKey from(String key) {
        validate(key);

        int index = convertEnumToKeys().indexOf(key);
        
        return ContinueKey.values()[index];
    }

    public static List<String> convertEnumToKeys() {
        List<String> result = new ArrayList<>();
    
        for (ContinueKey continueKey : ContinueKey.values()) {
            result.add(continueKey.getKey());
        }

        return result;
    }

    private static void validate(String key) {
        if (!convertEnumToKeys().contains(key)) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_CONTINUE_KEY_INPUT_ERROR.getMessage(convertEnumToKeys().toArray()));
        }
    }

    public String getKey() {
        return key;
    }
}
