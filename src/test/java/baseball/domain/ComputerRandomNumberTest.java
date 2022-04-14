package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputerRandomNumberTest {

        @DisplayName("랜덤 한자리 숫자를 뽑아본다.")
        @Test
        public void RandomNumTest() {
                int randomNumber = Randoms.pickNumberInRange(1, 1);
                assertThat(randomNumber).isNotNull().isEqualTo(1);

                assertEquals(randomNumber, 1);
        }

        @DisplayName("랜덤 세자리 숫자를 뽑아본다.")
        @Test
        public void RandomNum(){
                ArrayList<Integer> randomNum = new ArrayList<Integer>();
                List<Integer> list = Arrays.asList(1, 2, 3);

                while(randomNum.size() < 3){
                        int num = Randoms.pickNumberInRange(1, 1);
                        randomNum.add(num);
                }

                //원소 값이 존재하는 지 포함하는지에 대한 테스트
                assertThat(randomNum).isNotNull().contains(1,1,1);
                assertThat(list).isNotNull().containsExactly(1,2,3);

                //3개의 자리수
                assertThat(randomNum.size()).isEqualTo(3);

        }



}
