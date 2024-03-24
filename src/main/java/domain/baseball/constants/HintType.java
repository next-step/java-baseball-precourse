package domain.baseball.constants;

public enum HintType {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");
    private final String name;
    HintType(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
