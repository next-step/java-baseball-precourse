package baseball.controller;

import baseball.domain.ball.Balls;
import baseball.domain.player.PlayStatus;
import baseball.domain.player.Player;
import baseball.domain.score.Score;
import baseball.service.BallsGenerator;
import baseball.utils.StringUtils;
import baseball.view.BaseballIO;
import nextstep.utils.Console;

import static baseball.constant.Rule.COUNT_OF_BALLS;
import static baseball.constant.SystemMessage.*;
import static baseball.domain.player.PlayStatus.PLAY;

public class BaseballGame {

    private static BallsGenerator ballsGenerator;
    private static Balls computerBalls;
    private static Balls playerNumbers;

    public BaseballGame(BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public static void start() {
        computerBalls = ballsGenerator.generate();
        Player player = new Player(PLAY);
        initPlayerNumbers();
        while (player.isPlaying()) {
            playingGame();
            askReplay(player);
            reStartGame(player);
        }
    }

    private static void playingGame() {
        requirePlayerNumber();
    }

    private static void requirePlayerNumber() {
        while (isNotValidPlayerNumber() || isNotCorrectAnswer()) {
            generatePlayerNumber();
        }
    }

    private static boolean isNotValidPlayerNumber() {
        return playerNumbers == null || playerNumbers.isEmpty();
    }

    private static boolean isNotCorrectAnswer() {
        Score score = computerBalls.compare(playerNumbers);
        return !isCorrectAnswer(score);
    }

    private static boolean isCorrectAnswer(Score score) {
        if (score.getStrike() == COUNT_OF_BALLS) {
            BaseballIO.printlnMessage(CORRECT_ANSWER_MESSAGE);
            return true;
        }
        BaseballIO.printlnMessage(score.getScoreString());
        return false;
    }

    private static void generatePlayerNumber() {
        try {
            BaseballIO.printMessage(REQUIRE_NUMBER_MESSAGE);
            playerNumbers = Balls.valueOf(StringUtils.convertToIntList(Console.readLine()));
        } catch (Exception e) {
            initPlayerNumbers();
            BaseballIO.printlnMessage(e.getMessage());
        }
    }

    private static void initPlayerNumbers() {
        playerNumbers = null;
    }

    private static void reStartGame(Player player) {
        if (player.isPlaying()) {
            start();
            return;
        }
        //BaseballIO.printlnMessage(END);
    }

    private static void askReplay(Player player) {
        String response = null;
        do {
            BaseballIO.printlnMessage(ASK_REPLAY_MESSAGE);
            response = Console.readLine();
        } while (!isValidResponse(player, response));
        player.setPlayStatus(PlayStatus.getPlayStatus(response));
    }

    private static boolean isValidResponse(Player player, String response) {
        try {
            PlayStatus.getPlayStatus(response);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
