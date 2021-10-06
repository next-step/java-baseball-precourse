package baseball;

import baseball.domain.BaseballGame;
import baseball.view.ViewConsole;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        ViewConsole viewConsole = new ViewConsole();
        BaseballGame baseballGame= new BaseballGame(viewConsole);
        do{
            baseballGame.startNewGame();
        }while (!baseballGame.isEnd());

    }
}
