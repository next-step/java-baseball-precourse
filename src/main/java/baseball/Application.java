package baseball;


import static nextstep.utils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView();
        String continueGame = "1";

        while("1".equals(continueGame)){
            baseballView.playBaseball();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueGame = readLine();
        }

    }
}
