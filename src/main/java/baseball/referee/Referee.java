package baseball.referee;

import baseball.common.Message;

/**
 * author : hyeongju
 * date : 2022.09.29
 * description : 숫자 입력을 판정한다
 */
public class Referee {

    public boolean judge(String input, String correctAnswer) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < input.length(); i++) {
            String inputI = input.substring(i, i+1);
            String correctI = correctAnswer.substring(i, i+1);
            ballCount = getCount(!inputI.equals(correctI), input, correctI, ballCount);
            strikeCount = getCount(inputI.equals(correctI), input, correctI, strikeCount);
        }
        printCount(ballCount, strikeCount);

        return getIsPlay(strikeCount);
    }

    private static void printCount(int ballCount, int strikeCount) {
        printNothing(ballCount, strikeCount);
        printBall(ballCount);
        printStrike(strikeCount);
        printEnding(strikeCount);
    }

    private static void printNothing(int ballCaunt, int strikeCount){
        if(ballCaunt == 0 && strikeCount == 0){
            System.out.print(Message.MSG_RULE_NOTHING.getMessage());
        }
    }

    private static void printBall(int ballCount){
        if(ballCount > 0){
            System.out.print(ballCount + Message.MSG_RULE_BALL.getMessage() + " ");
        }
    }

    private static void printStrike(int strikeCount){
        if(strikeCount > 0){
            System.out.print(strikeCount + Message.MSG_RULE_STRIKE.getMessage() + " ");
        }
    }
    private static void printEnding(int strikeCount){
        System.out.println();
        if (strikeCount == 3){
            System.out.println(Message.MSG_GAME_ENDING.getMessage());
        }
    }

    private boolean getIsPlay(int strikeCount){
        if (strikeCount == 3){
            return false;
        }

        return true;
    }

    private static int getCount(boolean isNotEquals, String input, String correctI, int count) {
        if(isNotEquals && input.contains(correctI)){
            count++;
        }

        return count;
    }

}
