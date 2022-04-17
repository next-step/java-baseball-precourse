package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import baseball.service.ComputerService;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperatorControllerTest  extends NsTest {
    private ComputerService computerService = ComputerService.getInstance();

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

    @Override
    protected void runMain() {

    }
}
