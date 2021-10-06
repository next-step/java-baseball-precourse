package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Baseball game = new Baseball();
        int numCnt = 3;
        int answer;
        while(true)
        {
            game.runBaseBallGeme(numCnt, game.setRandomNums(numCnt));
            answer = game.goOrStop();
            if (answer == 1) {
                continue;
            }
            if (answer == 2) {
                break;
            }
        }
    }
}
