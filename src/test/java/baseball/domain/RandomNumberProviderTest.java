package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomNumberProviderTest {

    @Test
    void 랜덤숫자생성_NULL이아니여야한다() {
        List<Integer> randomNumber = RandomNumberProvider.randomNumberCreate();
        Assertions.assertNotNull(randomNumber);
    }

    @Test
    void 랜덤숫자생성_리스트에3개에난수가있어야한다() {
        List<Integer> randomNumber = RandomNumberProvider.randomNumberCreate();
        Assertions.assertEquals(randomNumber.size(), 3);
    }

}