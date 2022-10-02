package baseball.utils;

import baseball.domain.RandomNumberProvider;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.MockedStatic;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class RandomNumbersFixedProvider {

    private RandomNumbersFixedProvider() {
    }

    public static List<Integer> randomNumberCreate() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1, 3, 5);
            return RandomNumberProvider.randomNumberCreate();
        }
    }

}
