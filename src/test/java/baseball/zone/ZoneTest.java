package baseball.zone;

import baseball.ball.domain.BallNumber;
import baseball.zone.domain.Zone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("존")
class ZoneTest {

    @DisplayName("존 생성")
    @Test
    void createZone() {
        Zone zone = new Zone();
        assertDoesNotThrow(zone::generate);
        assertThat(zone.zones().size()).isEqualTo(3);
    }

    @DisplayName("존에 존 숫자가 같을 경우 추가되지 않는다.")
    @Test
    void createDuplicateZoneNumber() {
        Zone zone = new Zone();
        BigDecimal firstZoneNumber = BigDecimal.ONE;
        zone.addZone(firstZoneNumber);
        BigDecimal secondZoneNumber = BigDecimal.ONE;
        zone.addZone(secondZoneNumber);
        assertAll(
                () -> assertThat(zone.zoneNumbers().contains(new BallNumber(BigDecimal.ONE))).isTrue(),
                () -> assertThat(zone.zones().size()).isEqualTo(1)
        );
    }

    @DisplayName("4개 이상의 존를 추가할 수 없다.")
    @Test
    void maxZone() {
        Zone zone = new Zone();
        zone.addZone(BigDecimal.ONE);
        zone.addZone(BigDecimal.valueOf(2));
        zone.addZone(BigDecimal.valueOf(3));
        zone.addZone(BigDecimal.valueOf(4));
        assertAll(
                () -> assertThat(zone.zoneNumbers().contains(new BallNumber(BigDecimal.ONE))).isTrue(),
                () -> assertThat(zone.zoneNumbers().contains(new BallNumber(BigDecimal.valueOf(2)))).isTrue(),
                () -> assertThat(zone.zoneNumbers().contains(new BallNumber(BigDecimal.valueOf(3)))).isTrue(),
                () -> assertThat(zone.zoneNumbers().contains(new BallNumber(BigDecimal.valueOf(4)))).isFalse(),
                () -> assertThat(zone.zoneNumbers().contains(new BallNumber(BigDecimal.ONE))).isTrue(),
                () -> assertThat(zone.zones().size()).isEqualTo(3)
        );
    }

}
