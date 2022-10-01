package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IndexTest {

    @DisplayName("Index 클래스를 생성한다.")
    @Test
    void construct() {
        Index index = new Index(1);
        assertThat(index).isEqualTo(new Index(1));
    }

    @DisplayName("Index 클래스를 생성할 때, 0~2이 아닌 수는 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void construct(int index) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Index(index))
                .withMessageContaining("인덱스는 0이상, 3미만의 숫자만 가질 수 있습니다.");
    }
}