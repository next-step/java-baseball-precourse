package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import baseball.common.GameConfig;
import baseball.common.GameMessage;

@DisplayName("게임 서비스 테스트")
public class GameServiceTest {
    GameService computer;
    int digit;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void beforeEach() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        computer = new GameService();
        digit = GameConfig.RULE_NUMBER_DIGIT.getNumber();
    }

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void checkMakeRandomNumberTest() {
        List<Integer> randomNumber = computer.makeRandomNumber();
        assertThat(randomNumber.size()).isEqualTo(digit);

        Set<Integer> randomNumberSet = new HashSet<>(randomNumber);
        assertThat(randomNumberSet.size()).isEqualTo(digit);

        assertThat(randomNumber.contains(0)).isEqualTo(false);
    }

    @Test
    @DisplayName("ALL 스트라이크 테스트")
    void isSameRandomNumberTest() {
        List<Integer> testNumber = computer.makeRandomNumber();
        computer.setTargetNumber(testNumber);

        List<Integer> testProposalNumber = new ArrayList<>(testNumber);
        boolean isStrikeCountSameTargetDigit = computer.compareProposalNumber(testProposalNumber);
        assertThat(isStrikeCountSameTargetDigit).isEqualTo(true);

        String expectedPrint = GameMessage.STRIKE_RESULT.getMessageWithNumber(digit).concat(GameMessage.LINE_BREAK.getMessage());
        assertThat(outContent.toString()).isEqualTo(expectedPrint);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
