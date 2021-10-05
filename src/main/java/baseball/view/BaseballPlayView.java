package baseball.view;

import baseball.model.BaseballModel;

public class BaseballPlayView implements View {

    @Override
    public void print() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
