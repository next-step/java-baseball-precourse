package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallGameResultConverterTest {

    private BaseBallGameResultConverter baseBallGameResultConverter;

    @BeforeEach
    void setUp() {
        baseBallGameResultConverter = new BaseBallGameResultConverter();
    }

    @Test
    public void 게임결과_출력_낫싱() {
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{0, 0}), "낫싱");
    }

    @Test
    public void 게임결과_출력_스트라이크() {
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{1, 0}), "1스트라이크");
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{2, 0}), "2스트라이크");
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{3, 0}), "3스트라이크");
    }

    @Test
    public void 게임결과_출력_볼() {
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{0, 1}), "1볼");
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{0, 2}), "2볼");
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{0, 3}), "3볼");
    }

    @Test
    public void 게임결과_출력_스트라이크_볼_혼합() {
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{1, 2}), "1스트라이크 2볼");
        assertEquals(baseBallGameResultConverter.convertGameResult(new int[]{1, 1}), "1스트라이크 1볼");
    }
}
