package baseball.zone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("스트라이크 존스")
class StrikeZonesTest {

    @DisplayName("3개의 스트라이크 존 영역을 생성한다.")
    @Test
    void createStrikeZones() {
        StrikeZones strikeZones = new StrikeZones();
        StrikeZone firstStrikeZone = new StrikeZone(1, 1);
        StrikeZone secondStrikeZone = new StrikeZone(2, 3);
        StrikeZone thirdStrikeZone = new StrikeZone(3, 2);
        strikeZones.add(firstStrikeZone);
        strikeZones.add(secondStrikeZone);
        strikeZones.add(thirdStrikeZone);
    }

    @DisplayName("4개의 스트라이크 존 영역을 생성한다.")
    @Test
    void createStrikeZones_error() {
        StrikeZones strikeZones = new StrikeZones();
        StrikeZone firstStrikeZone = new StrikeZone(1, 1);
        StrikeZone secondStrikeZone = new StrikeZone(2, 3);
        StrikeZone thirdStrikeZone = new StrikeZone(3, 2);
        strikeZones.add(firstStrikeZone);
        strikeZones.add(secondStrikeZone);
        strikeZones.add(thirdStrikeZone);
        strikeZones.add(thirdStrikeZone);
    }
}
