package baseball.service.impl;

import baseball.domain.BaseballVO;
import baseball.service.BaseballOutputService;
import baseball.view.ViewService;
import baseball.view.impl.ViewServiceImpl;

public class BaseballOutputServiceImpl implements BaseballOutputService {

    private static final BaseballOutputServiceImpl instance = new BaseballOutputServiceImpl();
    public static BaseballOutputServiceImpl getInstance() {
        return instance;
    }
    private BaseballOutputServiceImpl() {}

    private ViewService viewService = ViewServiceImpl.getInstance();

    @Override
    public String returnMessage(BaseballVO baseballVO) {
        String result = viewService.outputMessage(baseballVO);

        return result;
    }
}
