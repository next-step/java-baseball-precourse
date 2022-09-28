package baseball.zone;

public class StrikeZone {

    private final int number;
    private final int location;

    public StrikeZone(int number, int location) {
        valid(location);
        this.number = number;
        this.location = location;
    }

    private void valid(int location) {
        if (!(0 < location && location < 4)) {
            throw new IllegalArgumentException("1 ~ 3 사이의 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public int getLocation() {
        return location;
    }

}
