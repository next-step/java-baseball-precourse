package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateNumberTest {

    private List<Integer> randoms;
    private GenerateNumber generateNumber;

    @BeforeEach
    void setUp() {
        generateNumber = new GenerateNumber();
        randoms = generateNumber.generate();
    }

    @Test
    void generate() {
        HashSet<Integer> set = new HashSet<>();
        for(int number : this.randoms) {
            set.add(number);
        }
        assertThat(set.size()).isEqualTo(3);
    }
}
