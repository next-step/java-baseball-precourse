package baseball.view;

import baseball.model.BaseballModel;
import baseball.model.GameStatus;

public class BaseballExceptionView implements View {

    private String message;
    private BaseballModel model;

    public BaseballExceptionView(BaseballModel model, IllegalArgumentException e) {
        this.model = model;
        this.message = e.getMessage();
    }

    @Override
    public void print() {
        System.out.println(message);
        if(model.getGameStatus() == GameStatus.STAGE_START)
            System.out.print("숫자를 입력해주세요 : ");
    }
}
