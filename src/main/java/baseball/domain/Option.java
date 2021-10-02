package baseball.domain;

public enum Option {
    START("1", true), END("2", false);

    private final String option;
    private final boolean restart;

    Option(String option, boolean restart) {
        this.option = option;
        this.restart = restart;
    }

    public static Option of(String option) {
        for (Option options : values()) {
            if (options.compareTo(option)) {
                return options;
            }
        }
        throw new IllegalArgumentException(option + "번 은 지원하지 않는 기능입니다.");
    }

    private boolean compareTo(String option) {
        return this.option.equals(option);
    }

    public boolean isReStart() {
        return restart;
    }
}
