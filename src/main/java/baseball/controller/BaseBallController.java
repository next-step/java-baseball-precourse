package baseball.controller;

import baseball.model.BaseBall;
import baseball.service.BaseBallService;
import baseball.view.BaseballView;

public class BaseBallController {
    private BaseBallService baseBallService;

    public BaseBallController(
            BaseBallService baseBallService
    ){
        this.baseBallService = baseBallService;
    }

    public String checkValidData(String input) {
        validationData(input);

        String result = "";

        BaseBall baseBall = baseBallService.countInputData(input);
        result = BaseballView.toSatusString(baseBall);

        return result;
    }

    private void validationData(String input) {
        try {
            Integer.parseInt(input);
            if (input.length() > 3) {
                throw new IllegalArgumentException("세자리 수를 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public boolean isStop() {
        boolean result = baseBallService.checkComplete();

        return result;
    }

    public void initData() {
        baseBallService.initData();
    }
}
