package baseball.view;

import baseball.model.BaseballModel;
import baseball.model.GameStatus;

public class BaseballResultView implements View {

    private BaseballModel baseballModel;

    public BaseballResultView(BaseballModel model) {
        this.baseballModel = model;
    }

    @Override
    public void print() {
        String result = "";
        if(baseballModel.getResult().containsKey("STRIKE"))
            result += baseballModel.getResult().get("STRIKE")+"스트라이크 ";
        if(baseballModel.getResult().containsKey("BALL"))
            result += baseballModel.getResult().get("BALL")+"볼 ";
        System.out.println(result.isEmpty() ? "낫싱" : result);

        if (baseballModel.getGameStatus() == GameStatus.STAGE_END) {
            System.out.println(baseballModel.getSize()+"개의 숫자를 모두 맞히셨습니다! 게임 끝");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            return;
        }
        System.out.print("숫자를 입력해주세요 : ");
    }
}
