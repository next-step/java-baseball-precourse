package baseball.service.impl;

import baseball.common.Constant;
import baseball.domain.BaseballVO;
import baseball.service.BaseballRuleService;

public class BaseballRuleServiceImpl implements BaseballRuleService {

    private static final BaseballRuleServiceImpl instance = new BaseballRuleServiceImpl();
    public static BaseballRuleServiceImpl getInstance() {
        return instance;
    }
    private BaseballRuleServiceImpl() {}

    @Override
    public BaseballVO checkAnswer(BaseballVO baseballVO) {

        this.cntStrike(baseballVO);
        this.cntBall(baseballVO);

        if (baseballVO.getCntStrike() == Constant.DEFAULT_ANSWER_LENGTH) {
            baseballVO.setStrike(true);
        }

        if (baseballVO.getCntStrike() + baseballVO.getCntBall() == 0) {
            baseballVO.setNothing(true);
        }

        return baseballVO;
    }

    private BaseballVO cntBall(BaseballVO baseballVO) {
        int cntBall = 0;
        for(int i = 0; i < Constant.DEFAULT_ANSWER_LENGTH; i ++) {
            cntBall += compareBall(baseballVO.getAnswerNumberList().get(i), baseballVO.getStrikeNumberList().get(i), baseballVO);
        }

        baseballVO.setCntBall(cntBall);

        return baseballVO;
    }

    private int compareBall(Integer answerArr, Integer strikeArr, BaseballVO baseballVO) {
        // 스트라이크인 경우는 제외
        if (compareStrike(answerArr,strikeArr) > 0) {
            return 0;
        }

        if (baseballVO.getStrikeNumberList().contains(answerArr)) {
            return 1;
        }

        return 0;
    }

    private BaseballVO cntStrike(BaseballVO baseballVO) {

        int cntStrike = 0;
        for(int i = 0; i < Constant.DEFAULT_ANSWER_LENGTH; i ++) {
            cntStrike += compareStrike(baseballVO.getAnswerNumberList().get(i), baseballVO.getStrikeNumberList().get(i));
        }

        baseballVO.setCntStrike(cntStrike);

        return baseballVO;
    }

    private int compareStrike(Integer answerArr, Integer strikeArr) {
        if (strikeArr.equals(answerArr)) {
            return 1;
        }
        return 0;
    }

}
