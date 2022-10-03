package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertUtilsTest {

    @Test
    void 숫자_to_리스트_변환(){
        String str = "123";
        List<Integer> compareStr = new ArrayList<>();
        compareStr.add(1);
        compareStr.add(2);
        compareStr.add(3);

        List<Integer> list = ConvertUtils.StringToList(str);

        boolean result = Arrays.equals(compareStr.toArray(),list.toArray());
        assertThat(result).isTrue();
    }
}
