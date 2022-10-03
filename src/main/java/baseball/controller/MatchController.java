package baseball.controller;

import static baseball.utils.Constants.CONTINUE_FLAG;
import static baseball.utils.ConvertUtil.convertIntegerToIntegerList;

import baseball.model.Computer;
import baseball.model.Match;
import baseball.model.Player;
import baseball.view.MatchView;

public class MatchController {
    private MatchView matchView;

    public void startMatchWithComputer() {
        Player inputPlayer = new Player();
        Player guessPlayer = new Computer();
        matchView = new MatchView();

        Match matchWithComputer = new Match(inputPlayer, guessPlayer);
        processMatch(matchWithComputer);
    }

    private void processMatch(Match match) {
        while(match.getContinueFlag().equals(CONTINUE_FLAG)) {
            // 사용자 입력 시작
            String typedNumber = matchView.startRound();
            // 사용자 입력값 반영
            match.setInputPlayerNumber(convertIntegerToIntegerList(typedNumber));
            // 사용자 입력값을 바탕으로 게임 결과 도출
            Integer ballCount = match.getPlayerBallCount();
            Integer strikeCount = match.getPlayerStrikeCount();
            matchView.showGameResult(ballCount, strikeCount);
            //게임을 계속할지 여부 검증
            String typedContinue = matchView.getContinueInput();
            match.setContinueFlag(typedContinue);
        }
    }
}