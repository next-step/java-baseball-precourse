package baseball.domain;

public enum StrikeZone {
    STRIKE("스트라이크"),BALL("볼"),NOTHING("낫싱");

    final private String name;
    StrikeZone(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
