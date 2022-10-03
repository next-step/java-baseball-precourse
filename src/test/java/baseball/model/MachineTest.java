package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class MachineTest {
    @Test
    void 두문자열_비교_낫싱_테스트() {
        String str1 = "123";
        String str2 = "456";

        HashMap<String,Integer> map = Machine.logic(str1,str2);
        assertThat(map.get("스트라이크")).isEqualTo(0);
        assertThat(map.get("볼")).isEqualTo(0);
    }

    @Test
    void 두문자열_비교_3스트라이크_테스트() {
        String str1 = "123";
        String str2 = "123";

        HashMap<String,Integer> map = Machine.logic(str1,str2);
        assertThat(map.get("스트라이크")).isEqualTo(3);
        assertThat(map.get("볼")).isEqualTo(0);
    }

    @Test
    void 두문자열_비교_1볼1_스트라이크_테스트() {
        String str1 = "123";
        String str2 = "521";

        HashMap<String,Integer> map = Machine.logic(str1,str2);
        assertThat(map.get("스트라이크")).isEqualTo(1);
        assertThat(map.get("볼")).isEqualTo(1);
    }
}