package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallConuterTest {
    @Test
    void can_create() {
        BaseballGeneratorStub baseballGeneratorStub = new BaseballGeneratorStub(Arrays.asList(1, 2, 3));
        BaseballCounter baseBallConuter = new BaseballCounter(baseballGeneratorStub);
    }

}
