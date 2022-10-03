package baseball.manage;

import baseball.constant.CommonConstant;
import baseball.model.Baseball;
import baseball.model.Config;
import baseball.model.Message;
import baseball.service.ManageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManageServiceTest {
    private ManageService manageService;

    @BeforeEach
    public void setService() {
        Config config = new Config();
        manageService = config.manageService();
    }

    @DisplayName("정상 야구게임 결과 출력")
    @ParameterizedTest
    @CsvSource(value = {"615:1볼", "892:1스트라이크", "765:낫싱", "813:2볼 1스트라이크", "831:3스트라이크"}, delimiter = ':')
    public void normalGameTest(String playerNum, String expectedAnswer) {
        String randomNum = "831";
        Baseball baseball = manageService.getAnswer(playerNum, randomNum);
        String result = new Message(baseball).getResultMeesage();

        assertEquals(expectedAnswer, result);
    }

    @DisplayName("야구게임 입력 값 오류 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "a1a", "A23", "!23", "1ㅎ3", "", "23", "012"})
    public void checkPlayNumTest(String val) {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> manageService.checkPlayerNum(val)
        );
    }

    @DisplayName("재시작 입력 값 오류 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"5", "", "t", "0"})
    public void checkRestartNumTest(String val) {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> manageService.checkRestartGameNumber(val)
        );
    }

}
