package baseball;

public enum GameResult {
    STRIKE("strike"),
    BALL("ball"),
    NOTHING("nothing");

    private final String value;

    GameResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean allMatch(GameResult[] arr, GameResult target) {
        boolean result = true;
        for (GameResult item : arr) {
            result &= item.equals(target);
        }
        return result;
    }
}
