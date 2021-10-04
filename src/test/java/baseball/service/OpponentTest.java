package baseball.service;

import baseball.Application;
import baseball.util.Constant;
import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class OpponentTest extends NSTest {
    private Opponent opponent = Opponent.getOpponent();

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 난수_확인() {
        try (MockedStatic<Opponent> opponentMockedStatic = mockStatic(Opponent.class)) {
            when(Opponent.getOpponent()).thenReturn(opponent);
            String generatedNum = opponent.makeNumber();
            assertEquals(Constant.NUMBER_SIZE, countLenth(generatedNum));
        }
    }

    private int countLenth(String generatedNum) {
        int len;
        try {
            len = generatedNum.length();
        } catch (NullPointerException e) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            numSet.add(generatedNum.charAt(i) - '0');
        }
        return numSet.size();
    }
}
