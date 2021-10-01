package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PitcherTest {

    @Test
    public void 난수_체크() throws Exception {
        //given
        String pitching = "";
        //when
        pitching = Pitcher.pitching();
        //then
        assertThat(pitching.length()).isEqualTo(3);
        assertThat(pitching.charAt(0) - '0').isLessThan(10);
        assertThat(pitching.charAt(1) - '0').isLessThan(10);
        assertThat(pitching.charAt(2) - '0').isLessThan(10);
    }
}