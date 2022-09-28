package baseball.zone;

import java.util.ArrayList;
import java.util.List;

public class StrikeZones {

    private final List<StrikeZone> strikeZones = new ArrayList<>();

    public void add(StrikeZone strikeZone) {
        validate(strikeZone);
        this.strikeZones.add(strikeZone);
    }

    private void validate(StrikeZone nextStrikeZone) {
        validateDuplicateStrikeZone(nextStrikeZone);
        validateMaxStrikeZones();
    }

    private void validateMaxStrikeZones() {
        if (strikeZones.size() >= 3) {
            throw new IllegalArgumentException("3개 이상의 스트라이크 존을 가질 수 없습니다.");
        }
    }

    private void validateDuplicateStrikeZone(StrikeZone nextStrikeZone) {
        for (StrikeZone strikeZone : this.strikeZones) {
            validateDuplicateStrikeNumber(nextStrikeZone, strikeZone);
            validateDuplicateStrikeLocation(nextStrikeZone, strikeZone);
        }
    }

    private static void validateDuplicateStrikeLocation(StrikeZone nextStrikeZone, StrikeZone strikeZone) {
        if (nextStrikeZone.getLocation() == strikeZone.getLocation()) {
            throw new IllegalArgumentException("같은 위치의 스트라이크 존을 생성할 수 없습니다.");
        }
    }

    private static void validateDuplicateStrikeNumber(StrikeZone nextStrikeZone, StrikeZone strikeZone) {
        if (nextStrikeZone.getNumber() == strikeZone.getNumber()) {
            throw new IllegalArgumentException("같은 숫자의 스트라이크 존을 생성할 수 없습니다.");
        }
    }
}
