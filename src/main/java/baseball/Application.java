package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        int opinion = GameRule.RESET;

        while (opinion == GameRule.RESET) {
            new GameRunner().run();
            OpinionInput opinionInput = new OpinionInput();
            opinion = opinionInput.getOpinion();
        }
    }
}
