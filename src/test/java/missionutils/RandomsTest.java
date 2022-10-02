package missionutils;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomsTest {

    @Test
    public void pickNumberInRange() {
        List<Integer> pickedNumbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            pickedNumbers.add(Randoms.pickNumberInRange(1, 10));
        }
        assertThat(pickedNumbers).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    public void pickUniqueNumbersInRange() {
        List<Integer> pickedUniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 10, 10);
        Collections.sort(pickedUniqueNumbers);
        assertThat(pickedUniqueNumbers).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    public void pickNumberInList() {
        List<Integer> testSourceNums = Arrays.asList(1, 3, 5);
        List<Integer> testResultNums = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testResultNums.add(Randoms.pickNumberInList(testSourceNums));
        }
        assertThat(testResultNums).containsOnly(1, 3, 5);
    }
}
