package baseball;

import baseball.service.BullsAndCows;

public class Application {

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        bullsAndCows.start();
    }

}
