package baseball;

public class Application {
    public static void main(String[] args) {
//         TODO 숫자 야구 게임 구현
        boolean gamingFlag = true;

        while (gamingFlag) {
            Baseball baseball = new Baseball();
            baseball.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 ");
            gamingFlag = baseball.endGame();
        }
    }
}
