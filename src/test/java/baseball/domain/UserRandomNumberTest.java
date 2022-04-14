package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Character.getNumericValue;

public class UserRandomNumberTest {

        @DisplayName("입력받은 문자열을 분할한다.")
        @Test
        public void InputNumberFormatTest(){
                String testNumber = "123";

                ArrayList<Integer> userNumbersList = new ArrayList<>();
                ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3));


                for (int i = 0; i < testNumber.length(); i++) {
                        //charat으로 분리 시 char 형변환으로 아스키코드 형식으로 저장됨으로 아스키코드를 넘버로 변경
                        userNumbersList.add( getNumericValue(testNumber.charAt(i)) );
                }

                assertThat(userNumbersList).isNotNull().containsExactly(1,2,3).isEqualTo(list);
        }



}
