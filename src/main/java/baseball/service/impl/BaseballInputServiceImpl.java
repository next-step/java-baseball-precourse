package baseball.service.impl;

import baseball.common.Constant;
import baseball.domain.BaseballVO;
import baseball.service.BaseballInputService;
import baseball.view.ViewService;
import baseball.view.impl.ViewServiceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class BaseballInputServiceImpl implements BaseballInputService {
    private static final BaseballInputServiceImpl instance = new BaseballInputServiceImpl();
    public static BaseballInputServiceImpl getInstance() {
        return instance;
    }
    private BaseballInputServiceImpl() {}

    private ViewService viewService = ViewServiceImpl.getInstance();

    @Override
    public String inputMessage(BaseballVO baseballVO) {
        String result = viewService.inputAnswer(baseballVO);

        return result;
    }

    @Override
    public void continueGame(BaseballVO baseballVO) {
        baseballVO.setMessage(BaseballVO.MESSAGE_END_REQUEST);
        String inputAnswer = viewService.inputAnswer(baseballVO);

        // 1 혹은 2가 입력되지 않은 경우 재귀
        if ( !(Constant.GAME_FINISH.equals(inputAnswer)
                || Constant.GAME_CONTINUE.equals(inputAnswer))) {
            this.continueGame(baseballVO);
        }

        // 게임종료 flag
        if (Constant.GAME_FINISH.equals(inputAnswer)) {
            baseballVO.setEndGame(true);
        }

        // 새로운 문제 셋팅
        if (Constant.GAME_CONTINUE.equals(inputAnswer)) {
            baseballVO.setRestart(true);
        }
    }

    @Override
    public boolean validationAnswer(BaseballVO baseballVO) {

        String answer = baseballVO.getUserAnswer();

        // Null 체크
        if (answer.isEmpty()) {
            baseballVO.setError(true, BaseballVO.ERROR_MESSAGE_LENGTH);
            return false;
        }

        // 3자리 숫자인지 체크
        if (answer.length() != Constant.DEFAULT_ANSWER_LENGTH) {
            baseballVO.setError(true, BaseballVO.ERROR_MESSAGE_LENGTH);
            return false;
        }

        // 유효범위 숫자만 입력 되었는지 체크
        int minNum = Constant.MIN_RANDOM_RANGE;
        int maxNum = Constant.MAX_RANDOM_RANGE;
        String regExp = "^["+minNum+"-"+maxNum+"]+$";
        if (!answer.matches(regExp)) {
            baseballVO.setError(true, BaseballVO.ERROR_MESSAGE_NUMBER);
            return false;
        }

        // 비교를 위한 자료구조 변경
        LinkedHashSet<Integer> answerSet = new LinkedHashSet<>();
        for (String byteAnswer : baseballVO.getUserAnswer().split("")) {
            answerSet.add(Integer.parseInt(byteAnswer));
        }
        List<Integer> convertResult = new ArrayList<>(answerSet);

        // 중복 숫자 체크
        if (convertResult.size() != Constant.DEFAULT_ANSWER_LENGTH) {
            baseballVO.setError(true, BaseballVO.ERROR_MESSAGE_DUPLICATE);
            return false;
        }

        // 입력값 셋팅
        baseballVO.setAnswerNumberList(convertResult);

        return true;
    }
}
