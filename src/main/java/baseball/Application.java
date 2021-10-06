package baseball;

import baseball.ui.Game;

public class Application {
    public static void main(String[] args) {
        int startNumber = 1;

        while (startNumber == 1){
            startNumber = Game.start();
        }

        if(startNumber == 2){
            return;
        }
    }
}
