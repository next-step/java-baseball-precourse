package baseball.vo.enumtype;

public enum Inclusive {
    START(1), END(9);

    private Integer value;

    Inclusive(Integer value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public Integer getValue() {
        return value;
    }
}
