package baseball.service.impl;

import baseball.common.Constant;
import baseball.domain.BaseballVO;
import baseball.service.BaseballInputService;
import baseball.service.BaseballOutputService;
import baseball.service.BaseballProcessService;
import baseball.service.BaseballRuleService;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class BaseballProcessServiceImpl implements BaseballProcessService {

    private static final BaseballProcessServiceImpl instance = new BaseballProcessServiceImpl();
    public static BaseballProcessServiceImpl getInstance() {
        return instance;
    }
    private BaseballProcessServiceImpl() {}

    private BaseballRuleService ruleService = BaseballRuleServiceImpl.getInstance();
    private BaseballInputService inputService = BaseballInputServiceImpl.getInstance();
    private BaseballOutputService outputService = BaseballOutputServiceImpl.getInstance();

    private static List<Integer> strikeNumberList;

    @Override
    public void initGame() {

        // 객체 초기화
        BaseballVO baseballVO = new BaseballVO();

        try {
            // 랜덤한 3자리 숫자 생성
            List<Integer> randomInt = this.makeRandomCase();
            strikeNumberList = randomInt;
            baseballVO.setStrikeNumberList(randomInt);
            // 게임 시작
            this.startGame(baseballVO);

        } catch (Exception e) {
            e.printStackTrace();
            baseballVO.setError(true, BaseballVO.ERROR_MESSAGE_EXCEPTION);
            outputService.returnMessage(baseballVO);
        }

    }

    private String startGame(BaseballVO baseballVO) {

        // 사용자 입력받기
        baseballVO.setMessage(BaseballVO.MESSAGE_INPUT_REQUEST);
        String answer = inputService.inputMessage(baseballVO);
        baseballVO.setUserAnswer(answer);

        // 유효성검사
        boolean isValid = inputService.validationAnswer(baseballVO);

        // 채점
        if (isValid) {
            ruleService.checkAnswer(baseballVO);
        }

        // 결과 출력
        outputService.returnMessage(baseballVO);

        // 스트라이크인 경우
        if (baseballVO.isStrike()) {
            // 게임 지속 판단
            inputService.continueGame(baseballVO);
        }

        // 새로운 문제 셋팅
        if (baseballVO.isRestart()) {
            strikeNumberList = this.makeRandomCase();
        }

        // 종료시까지 재귀
        if (!baseballVO.isEndGame()) {
            // 객체 초기화
            baseballVO = new BaseballVO();
            baseballVO.setStrikeNumberList(strikeNumberList);
            this.startGame(baseballVO);
        }

        return Constant.SUCCESS;
    }

    @Override
    public List<Integer> makeRandomCase() {
        LinkedHashSet<Integer> randomNumber = new LinkedHashSet<>();

        // 중복 제거 될 때까지 반복
        while(randomNumber.size() < Constant.DEFAULT_ANSWER_LENGTH){
            int num = Randoms.pickNumberInRange(1, 9);
            randomNumber.add(num);
        }

        // 정답확인용
//        System.out.println("[정답은?"+randomNumber+"]");

        List<Integer> list = new ArrayList<>(randomNumber);
        return list;
    }

}
