package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void firstRequirements(){
        String firstTestString = "1,2";
        String secondTestString = "1";
        String splitValue = ",";

        String[] firstTestStringSplitArr = firstTestString.split(splitValue);
        assertThat(firstTestStringSplitArr).contains("1", "2");

        String[] secondTestStringSplitArr = secondTestString.split(splitValue);
        assertThat(secondTestStringSplitArr).containsExactly("1");
    }

    @Test
    void secondRequirements(){
        String firstTestString = "(1,2)";
        firstTestString = firstTestString.substring(1,firstTestString.length()-1);
        assertThat(firstTestString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 charAt()을 활용해 특정 위치 문자 가져오기 ")
    void thirdRequirements(){

        String firstTestString = "abc";
        int outIndex = 3;

        assertThatThrownBy(() -> {
            firstTestString.charAt(outIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: "+outIndex);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
             firstTestString.charAt(outIndex);
        }).withMessageMatching("String index out of range: "+outIndex);
    }

}
