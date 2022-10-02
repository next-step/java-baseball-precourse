package baseball.controller;

import baseball.domain.RandomNumberProvider;
import baseball.service.BaseballPlay;

public class BaseballGame {
    public static void main(String[] args) {
        boolean game = true;
        while(game) {
            BaseballPlay baseballPlay = new BaseballPlay();
            game = baseballPlay.play();
        }
    }
}
