package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class junitTest {
    @Test
    @DisplayName("1,2 split")
    void split(){
        String number = "1,2";
        String[] numberSplit = number.split(",");

        Assertions.assertThat(numberSplit).contains("1", "2");
    }

    @Test
    @DisplayName("1만 split")
    void singleSplit(){
        String number = "1";
        String[] numberSplit = number.split(",");

        Assertions.assertThat(numberSplit).contains("1");
    }

    @Test
    void subString(){
        String numberIncludeChar = "(1,2)";
        Assertions.assertThat(numberIncludeChar.substring(1,3)).isEqualTo("1,2");
    }

    @Test
    void charAt(){
        String alphabet = "abc";
        Assertions.assertThat(alphabet.charAt(1)).isEqualTo("b");
    }

    @Test
    void charAtOverSize(){
        String alphabet = "abc";
        Assertions.assertThatThrownBy(()->alphabet.charAt(10)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
