package baseBall;

import Utils.RandomNumber;
import camp.nextstep.edu.missionutils.Console;
import domain.Match;
import domain.RoundResult;
import policy.Policy;

public class GameProcess {
    public void run(){
        Match match = Match.init(RandomNumber.get());

        System.out.println("경기 시작");

        while (match.getRound() <= Policy.MATCH_ROUND_END){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            String[] userInputSplit = userInput.split("");

            RoundResult roundResult = calc(match, userInputSplit);
            if(roundResult.getStrikeCount()==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }

            System.out.println(roundResult.getBallCount() + "볼 " + roundResult.getStrikeCount() + "스트라이크");

            match.endOfRound();
        }

        System.out.println("경기 종료");
    }

    public RoundResult calc(Match match, String[] userInput){
        int strikeCount = 0;
        int ballCount = 0;
        for(int a=0; 3>a; a++){
            for(int b=0; 3>b; b++){
                if(userInput[a].equals(match.getGameNumber()[b])){
                    if(a==b){
                        strikeCount++;
                    }else{
                        ballCount++;
                    }
                }
            }
        }

        return RoundResult.init(ballCount, strikeCount);
    }
}
