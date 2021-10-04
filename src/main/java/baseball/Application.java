package baseball;

import baseball.service.Game;
import baseball.service.Opponent;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        // 게임 진행
        Game game = Game.getGameInstance();
        do {
            // 난수 생성
            String number = Opponent.getOpponent().makeNumber();
            // 게임 진행
            game.play(number);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
        while (game.isEndFromInput());
    }
}
