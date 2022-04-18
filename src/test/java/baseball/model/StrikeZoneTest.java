package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeZoneTest {
    @Test
    @DisplayName("랜덤_스트라이크_존_생성")
    void 랜덤_스트라이크_존_생성(){
        assertThat(new HashSet(new StrikeZone().getZones()))
                .isNotEmpty()
                .hasSize(3);
    }
}
