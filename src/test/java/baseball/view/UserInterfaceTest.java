package baseball.view;

import baseball.Constants.UserInterfaceMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown(){
        System.setOut(standardOut);
    }

    @Test
    void 게임결과_출력_낫싱(){
        //given
        boolean isNothing = true;
        boolean isWinning = false;
        int ballCnt = 0;
        int strikeCnt = 0;

        //when
        UserInterface.printRoundResult(isNothing, isWinning, ballCnt, strikeCnt);

        //then
        assertEquals(UserInterfaceMessage.ROUND_RESULT_NOTHING+"\n", outputStreamCaptor.toString());
    }

    @Test
    void 게임결과_출력_승리(){
        //given
        boolean isNothing = false;
        boolean isWinning = true;
        int ballCnt = 0;
        int strikeCnt = 3;

        //when
        UserInterface.printRoundResult(isNothing, isWinning, ballCnt, strikeCnt);

        //then
        assertEquals(strikeCnt + UserInterfaceMessage.ROUND_RESULT_STRIKE + "\n"
                        +UserInterfaceMessage.ROUND_RESULT_WINNING+"\n"
                , outputStreamCaptor.toString());
    }

}