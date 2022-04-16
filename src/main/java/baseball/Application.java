package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseballGame game = new NumberBaseballGame(3);

        while (game.isPlay()){
            String value = Console.readLine();
            if(!game.playing(value)){
                game.restart();
            }
        }
    }
}
