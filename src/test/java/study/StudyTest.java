package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StudyTest {

    @Test
    void test1() {
        // given
        String example = "1,2";

        // when
        String[] result = example.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).contains("1", "2");
    }

    @Test
    void test2() {
        // given
        String example = "1";

        // when
        String[] result = example.split(",");

        // then
//        assertThat(example).containsExactly("1");
    }

}
