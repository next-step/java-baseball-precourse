package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class UtilsTest {

    @Test
    void convertIntegerArrayTest(){
        List<Integer> expect = Arrays.asList(1,2,3);

        List<Integer> result = Utils.convertIntegerArray("123");

        assertThat(expect).isEqualTo(result);
    }
}
