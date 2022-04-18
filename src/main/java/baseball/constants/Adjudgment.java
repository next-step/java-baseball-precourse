package baseball.constants;

public enum Adjudgment {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    public String word;

    Adjudgment(String word){
        this.word = word;
    }
}
