package baseball.view;

import baseball.Constants.UserInterfaceMessage;
import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    public static String askUserInputBaseBallNumber(){
        System.out.print(UserInterfaceMessage.USER_INPUT_BASEBALL_MSG);
        return Console.readLine();
    }

    public static String askUserInputGameStatusNumber(){
        System.out.println(UserInterfaceMessage.USER_INPUT_GAME_STATUS_MSG);
        return Console.readLine();
    }

    public static void printRoundResult(boolean isNothing, boolean isWinning, int ballCnt, int strikeCnt){
        if(isNothing){
            System.out.println(UserInterfaceMessage.ROUND_RESULT_NOTHING);
            return;
        }
        if(isWinning){
            System.out.println(strikeCnt + UserInterfaceMessage.ROUND_RESULT_STRIKE);
            System.out.println(UserInterfaceMessage.ROUND_RESULT_WINNING);
            return;
        }
        if(ballCnt > 0){
            System.out.print(ballCnt + UserInterfaceMessage.ROUND_RESULT_BALL + " ");
        }
        if(strikeCnt > 0){
            System.out.print(strikeCnt + UserInterfaceMessage.ROUND_RESULT_STRIKE);
        }
        System.out.println();
    }
}
