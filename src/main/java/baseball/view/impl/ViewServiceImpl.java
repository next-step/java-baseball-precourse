package baseball.view.impl;

import baseball.common.Constant;
import baseball.domain.BaseballVO;
import baseball.view.ViewService;
import nextstep.utils.Console;

public class ViewServiceImpl implements ViewService {

    private static final ViewServiceImpl instance = new ViewServiceImpl();

    public static ViewServiceImpl getInstance() {
        return instance;
    }
    private ViewServiceImpl() {}

    @Override
    public String inputAnswer(BaseballVO baseballVO) {
        System.out.print(baseballVO.getMessage());
        String answer = Console.readLine();
        return answer;
    }

    @Override
    public String outputMessage(BaseballVO baseballVO) {

        try {
            System.out.println(baseballVO.resultMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }

        return Constant.SUCCESS;
    }

}
