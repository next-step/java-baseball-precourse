package baseball.service;

import baseball.common.Constants;
import baseball.domain.ScoreBoard;
import baseball.dto.BaseballDTO;
import baseball.repository.BaseBallRepository;
import baseball.util.CommonUtils;
import baseball.util.RandomUtils;

import java.util.List;

public class BaseBallService {

    private final BaseBallRepository baseBallRepository;

    public BaseBallService() {
        this.baseBallRepository = new BaseBallRepository();
    }

    public void initAnswer() {
        final List<Integer> answer = RandomUtils.generateNonRepeatRandomNumber(Constants.LIMIT_DIGITS);

        baseBallRepository.initAnswer(answer);
    }

    public BaseballDTO.ResResult submitAnswer(final String userAnswerStr) {
        final List<Integer> answer = baseBallRepository.getAnswer();
        final List<Integer> userAnswer = CommonUtils.convertStringArrayToIntegerList(userAnswerStr.split(""));
        final ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.countScore(answer, userAnswer);

        return new BaseballDTO.ResResult(scoreBoard);
    }
}
