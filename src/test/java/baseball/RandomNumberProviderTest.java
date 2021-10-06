package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberProviderTest {

    @Test
    void 길이가_3인_문자열을_반환한다() {
        //given, when
        String result = RandomNumberProvider.generate();

        //then
        assertThat(result).hasSize(3);
    }
}