package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallGameNumberComparatorTest {

    private BaseBallGameNumberComparator baseBallGameNumberComparator;

    @BeforeEach
    void setUp() {
        baseBallGameNumberComparator = new BaseBallGameNumberComparator(BaseBallGame.DEFAULT_LENGTH);
    }
}
