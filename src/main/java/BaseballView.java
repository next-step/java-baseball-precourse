public class BaseballView {
    public void printTurnInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printScore(TurnResult score) {
        if (score.strike != 0) {
            System.out.print(score.strike + "스트라이크 ");
        }

        if (score.ball != 0) {
            System.out.print(score.ball + "볼 ");
        }

        if (score.strike == 0 && score.ball == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }

    public void printWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void printExitOrRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printInputErrorMessage(){
        System.out.println("[ERROR] 올바른 입력을 해주세요.");
    }
}
