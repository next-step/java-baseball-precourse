import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class RandomNumberTest {
    @Test
    @DisplayName("RandomNumberTest")
    void DuplicationAndSizeTest(){
        //given
        ArrayList<Integer> list = RandomNumber.generateRandomNumber();
        Set<Integer> set = new HashSet<>(list);
        int num = 3;
        //when & then
        assertThat(set.size()).isEqualTo(3); //중복확인
        assertThat(list.size()).isEqualTo(num);//개수확인
    }
}
