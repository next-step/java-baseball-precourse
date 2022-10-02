package baseball.domain.computer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {


    @Test
    public void 랜덤값_사이즈_테스트(){
        Computer com = new Computer();

        List<Integer> actualList = com.getRANDOM_NUMBER();

        String strActual = String.valueOf(actualList.get(0));

        assertThat(strActual).hasSize(3);
    }

}