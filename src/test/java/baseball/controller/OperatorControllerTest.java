package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import baseball.service.ComputerService;
import baseball.service.ComputerServiceTest;
import baseball.service.PlayerService;
import baseball.service.ValidatorServiceTest;
import baseball.vo.enumtype.InterfaceMsg;
import baseball.vo.enumtype.ValidationMsg;
import camp.nextstep.edu.missionutils.test.NsTest;

public class OperatorControllerTest  extends NsTest {
    private ComputerService computerService = ComputerService.getInstance();
    private ComputerServiceTest computerServiceTest = ComputerServiceTest.getInstance();
    private PlayerService playerService = PlayerService.getInstance();

    private String inputGameNumber;

    @Test
    void Computer에게_새로운_야구게임이_시작됨을_알리고_Computer로부터_받은_값_출력() {
        computerService.initGameNumber();
        System.out.println(computerService.getGameNumberDto().getGameNumberList());
    }

    @Test
    void Computer로부터_여러_번_받은_값이_동일한지_체크() {
        // give & when
        List<Integer> integerList = computerService.getGameNumberDto().getGameNumberList();
        // then
        assertEquals(computerService.getGameNumberDto().getGameNumberList(), integerList);
    }

    @Test
    void 새로운_야구게임이_시작될_때_Computer로부터_받은_값이_변경되는지_확인() {
        // give
        List<Integer> integerList = computerService.getGameNumberDto().getGameNumberList();

        // when
        computerService.initGameNumber();

        //then
        assertNotEquals(computerService.getGameNumberDto().getGameNumberList(), integerList);
    }

    @Test
    void 야구게임_입력_숫자_검증() {
        assertThrows(IllegalArgumentException.class, () -> {
            System.out.print(InterfaceMsg.REQUEST_INPUT.getValue()); run("1234");
            String userGameNumber = readLine(); System.out.println(userGameNumber);
            ValidationMsg validationMsg = ValidatorServiceTest.getInstance().validationUserInput(userGameNumber);
            if (validationMsg != ValidationMsg.PROPER_TYPE) {
                System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
            }
        });
    }

    @Test
    void player가_가진_숫자값과_computer가_가진_숫자값_비교() {
        // give
        String inputGameNumber = "365";
        // when
        playerService.setPlayerInputGameNumber(inputGameNumber);
        computerServiceTest.setPlayerInputGameNumberList(playerService.getPlayerInputGameNumberDto().getGameNumberList());
        // then
        assertEquals(inputGameNumber, listInteger2String(computerServiceTest.getPlayerInputGameNumberList()));
    }

    /**
     * List<Integer>를 입력받아, 하나의 문자열로 반환
     * @param playerInputList
     * @return
     */
    private String listInteger2String(List<Integer> playerInputList) {
        return playerInputList.toString().replaceAll("[^0-9]", "");
    }

    @Override
    protected void runMain() {

    }
}
