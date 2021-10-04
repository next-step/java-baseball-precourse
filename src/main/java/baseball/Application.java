package baseball;

import baseball.controller.Player;
import baseball.model.enums.AnswerSize;
import baseball.model.enums.UserSelect;
import baseball.model.utils.RandomBallNumberGenerator;
import nextstep.utils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnswerSize answerSize = AnswerSize.THREE;
        Player player = new Player();

        while (player.isReady()) {
            startNewGame(answerSize, player);
            repeatGuessAnswer(player);
            gameOver(answerSize);
            selectRestart(player);
        }
    }

    /**
     * 게임 시작하면서 랜덤한 숫자 생성
     */
    private static void startNewGame(AnswerSize answerSize, Player player) {
        List<Integer> numbers = RandomBallNumberGenerator.generate(answerSize);
        player.startNewGame(numbers);
    }

    /**
     * 플레이어가 정답을 맞출 때까지 입력 후 비교 반복
     */
    private static void repeatGuessAnswer(Player player) {
        while (player.isPlayingWithWrongAnswer()) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            String resultMessage = player.guessAnswer(input);
            System.out.println(resultMessage);
        }
    }

    /**
     * 게임 종료 메세지
     *
     * @param answerSize 몇개 맞췄는지 알려주기 위한 정답 크기
     */
    private static void gameOver(AnswerSize answerSize) {
        System.out.println(answerSize + "개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    /**
     * 게임 종료 후 재시작 여부 선택
     */
    private static void selectRestart(Player player) {
        while (player.alreadyGetRightAnswer()) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            player.restartOrExit(UserSelect.of(input));
        }
    }
}
