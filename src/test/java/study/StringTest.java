package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    void split1() {
        String orgStr = "1,2";
        assertThat(orgStr.split(",")).containsExactly("1", "2");
    }

    void split2() {
        String orgStr = "1";
        assertThat(orgStr.split(",")).contains("1");
    }

    void substring() {
        String orgStr = "(1,2)";
        assertThat(orgStr.substring(1, orgStr.length() - 1)).isEqualTo("1,2");
    }

    void charAt(int index, char singleStr) {
        String orgStr = "abc";
        assertThat(orgStr.charAt(index - 1)).isEqualTo(singleStr);
    }

    void charAt_error() {
        String orgStr = "abc";
        assertThatThrownBy(() -> orgStr.charAt(orgStr.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
