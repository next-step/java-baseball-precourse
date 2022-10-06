package baseball.controller;

import baseball.model.Game;
import baseball.model.Player;
import baseball.model.User;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    public static Map<String, Integer> getCompareResultByInput(Player computer, String userInput) {
        Player user = new User(userInput);
        Map<String, Integer> result = new HashMap<>();
        Game game = new Game(user, computer);

        result.put("strike", game.getStrike());
        result.put("ball", game.getBall());
        result.put("nothing", game.getNothing());

        return result;
    }
}
