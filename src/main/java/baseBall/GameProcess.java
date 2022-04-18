package baseBall;

import Utils.RandomNumber;
import Utils.UserInput;
import config.Policy;
import domain.Match;
import domain.RoundResult;

public class GameProcess {
    public void run(){
        Match match = Match.init(RandomNumber.get());

        System.out.println("게임 시작");

        while (!isEndMatch(match)){
            String userInputSplit = UserInput.inGame();

            RoundResult roundResult = roundProcessing(match.getGameNumber(), userInputSplit);
            System.out.println(roundResult.getBallCount() + "볼 " + roundResult.getStrikeCount() + "스트라이크");

            match.endOfRound(roundResult);
        }

        if(match.isVictory()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        System.out.println(match.getGameNumber() + " : 게임 종료");
    }

    private boolean isEndMatch(Match match){
        return (match.getRound() > Policy.MATCH_ROUND_END) || match.isVictory();
    }

    private RoundResult roundProcessing(String gameNumber, String userInput){
        RoundResult roundResult = RoundResult.init();

        for(int a=0; Policy.IN_GAME_NUMBER_LENGTH>a; a++){
            for(int b=0; Policy.IN_GAME_NUMBER_LENGTH>b; b++){
                if(userInput.charAt(a) == gameNumber.charAt(b)){
                    if(a==b){
                        roundResult.addStrike();
                    }else{
                        roundResult.addBall();
                    }
                }
            }
        }

        return roundResult;
    }
}
