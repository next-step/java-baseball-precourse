package baseball;

import baseball.domain.BaseballGame;
import baseball.feature.Service;
import baseball.feature.ServiceImpl;
import baseball.ui.UI;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        BaseballGame game;

        UI ui = new UI();
        Service service = new ServiceImpl();

        do {
            game = new BaseballGame(ui, service);
            game.play();
        } while (game.continuePlay());

    }


}



/*
    - 숫자입력받기
            - 입력값 유효성 확인하기
            - 값 출력하기
            - 입력받은 숫자로 응답값 산출하기
            - 스트라이크 판별하기(같은위치, 같은 값)
            - 볼 판별하기 (다른 위치, 같은 값)
*/

