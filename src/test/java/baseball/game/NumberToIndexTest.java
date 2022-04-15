package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberToIndexTest {
    @Test
    @DisplayName("put() 1,2,3을 각각 넣으면, 3개가 추가됨")
    void put_1And2And3OneAtATime_3ItemsAdded() {
        NumberToIndex target = new NumberToIndex();
        target.put(1);
        target.put(2);
        target.put(3);

        assertThat(target.size()).isEqualTo(3);
        assertThat(target.getIndexOf(1)).isEqualTo(0);
        assertThat(target.getIndexOf(2)).isEqualTo(1);
        assertThat(target.getIndexOf(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("put() 1,2,3을 String으로 넣으면, 3개가 추가됨")
    void constructor_With123AsString_3ItemsAdded() {
        NumberToIndex target = new NumberToIndex("123");

        assertThat(target.size()).isEqualTo(3);
        assertThat(target.getIndexOf(1)).isEqualTo(0);
        assertThat(target.getIndexOf(2)).isEqualTo(1);
        assertThat(target.getIndexOf(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("생성자 호출 시 1234를 String으로 넘기면, IllegalArgumentException 예외")
    void constructor_With1234AsString_ThrowsIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberToIndex("1234"));
    }

    @Test
    @DisplayName("생성자 호출 시 120를 String으로 넘기면, IllegalArgumentException 예외")
    void constructor_With120AsString_ThrowsIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberToIndex("120"));
    }
}
