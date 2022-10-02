package baseball.console;

import java.util.HashMap;
import java.util.Map;

enum EndCode {
    CONTINUE("1", false),
    EXIT("2", true);
    
    private static final Map<String, EndCode> CACHE_MAP;
    private final String code;
    private final boolean isExit;
    
    static {
        Map<String, EndCode> tempMap = new HashMap<>();
        for (EndCode endCode : EndCode.values()) {
            if (tempMap.put(endCode.getCode(), endCode) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        CACHE_MAP = tempMap;
    }
    
    EndCode(String code, boolean isExit) {
        this.code = code;
        this.isExit = isExit;
    }
    
    public static boolean isExit(String text) {
        EndCode endCode = CACHE_MAP.get(text);
        if (endCode == null) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        return endCode.isExit;
    }
    
    public String getCode() {
        return code;
    }
    
}
