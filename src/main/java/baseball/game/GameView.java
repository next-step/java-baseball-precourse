package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    
    public static String inputView(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void outputView(GameRoundResult gameRoundResult){
        String result = "";
        if (gameRoundResult.getBall() > 0){
            result += String.format("%d볼", gameRoundResult.getBall());
        }
        if (gameRoundResult.getStrike() > 0){
            result += String.format(" %d스트라이크", gameRoundResult.getStrike());
        }
        result = result.trim();
        if (gameRoundResult.getBall() == 0 && gameRoundResult.getStrike() == 0){
            result = "낫싱";
        }
        System.out.println(result);
    }

    public static String roundView(){
        System.out.println("1. 게임 다시 시작하기");
        System.out.println("2. 게임 종료");
        return Console.readLine();
    }
}
