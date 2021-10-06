package baseball;


import utils.BaseballUtils;

//        1. 전체 프로그램 sequence 관리 - Main
//        2. baseball Game 정답 숫자 생성하기 - Game
//        3. 유저에게 숫자 입력 요청문 출력하기 - UI
//        4. 숫자 입력하기 - User(Console)
//        5. 유저 입력 validation 하기 - Game
//        6. 에러 메시지 출력하기 - UI
//        7. 유저 입력 채점하기 (스트라이크 볼 낫싱, count Map return) - Game
//        8. 유저가 맞췄는지 여부 알아내기 - Game
//        9. 게임 종료 메시지 출력하기 - UI
//        10. 게임 재시작 질의 출력하기 - UI
//        11. 게임 재시작여부 질의 판단하기 - UI
public class Application {
    public static void main(String[] args) {

        int[] gameAnswer = BaseballGame.generateGameAnswer();
        BaseballGame game = new BaseballGame(gameAnswer);

        while (true) {
            if (game.isFinished()) game = new BaseballGame(BaseballGame.generateGameAnswer());
            game.initGrade();
            GameUI.printNumberInputRequest();
            String userInput = GameUI.userInput();

            if (!BaseballGame.isValid(userInput)) {
                GameUI.printInvalidInputErrorMessage();
                continue;
            }

            int[] inputNumbers = BaseballUtils.userInputToIntArray(userInput);
            game.grade(inputNumbers);

            if (game.allMatch()) {
                GameUI.printAllMatchMessage();
                GameUI.printAskRetryMessage();
                game.complete();
                String retryInput = GameUI.userInput();
                if (GameUI.isRetryNeeded(retryInput)) continue;
                return;
            }

            if (game.nonMatch()) {
                GameUI.printNothing();
                continue;
            }

            GameUI.printGrade(game.getStrikeCount(), game.getBallCount());
        }
    }

}
