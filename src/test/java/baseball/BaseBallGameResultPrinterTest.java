package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallGameResultPrinterTest {

    private BaseBallGameResultPrinter baseBallGameResultPrinter;

    @BeforeEach
    void setUp() {
        baseBallGameResultPrinter = new BaseBallGameResultPrinter();
    }

    @Test
    public void 게임결과_출력_낫싱() {
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{0, 0}), "낫싱");
    }

    @Test
    public void 게임결과_출력_스트라이크() {
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{1, 0}), "1스트라이크");
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{2, 0}), "2스트라이크");
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{3, 0}), "3스트라이크");
    }

    @Test
    public void 게임결과_출력_볼() {
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{0, 1}), "1볼");
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{0, 2}), "2볼");
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{0, 3}), "3볼");
    }

    @Test
    public void 게임결과_출력_스트라이크_볼_혼합() {
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{1, 2}), "1스트라이크 2볼");
        assertEquals(baseBallGameResultPrinter.convertGameResult(new int[]{1, 1}), "1스트라이크 1볼");
    }
}
