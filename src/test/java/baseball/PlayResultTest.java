package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayResultTest {


    @Test
    void StrikeTest() {
        PlayResult playResult = PlayResult.of();

        playResult.reulstCount(Status.STRIKE);
        playResult.reulstCount(Status.BALL);
        playResult.reulstCount(Status.NOTHING);

        assertThat(playResult.strikeCount()).isEqualTo(1);
        assertThat(playResult.ballCount()).isEqualTo(1);
        assertThat(playResult.nothingCount()).isEqualTo(1);
    }
}