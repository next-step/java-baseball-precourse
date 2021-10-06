package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TargetNumberProviderTest {

    @Test
    void 길이가_3인_문자열을_반환한다() {
        //given, when
        String result = TargetNumberProvider.generate();

        //then
        assertThat(result).hasSize(3);
    }
}