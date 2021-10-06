package baseball.view;

import baseball.domain.Decision;
import baseball.domain.StrikeZone;
import baseball.domain.User;
import nextstep.utils.Console;

import java.util.Collections;

public class ConsoleView {

    public static String readInput(User user){
        if(user != null && Decision.SUCCESS.equals(user.getDecision()) && !user.getIsEndPlay()){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            user.setDecision(user.getDecision());
            return Console.readLine();
        }
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void decision(User user) {
        if(Decision.SUCCESS.equals(user.getDecision())){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return;
        }
        if(Decision.DOING.equals(user.getDecision())) {
            int countStrike = Collections.frequency(user.getDecisionList(), StrikeZone.STRIKE);
            int countBall = Collections.frequency(user.getDecisionList(), StrikeZone.BALL);
            String message = "";
            if(countStrike > 0){
                message += countStrike + StrikeZone.STRIKE.getName() + " ";
            }
            if(countBall > 0){
                message += countBall + StrikeZone.BALL.getName() + " ";
            }
            if(countStrike == 0 && countBall == 0){
                message = StrikeZone.NOTHING.getName();
            }
            System.out.println(message);
        }
    }
}
