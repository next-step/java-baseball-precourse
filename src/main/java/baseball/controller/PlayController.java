package baseball.controller;

import baseball.model.StrikeZone;
import baseball.player.Pitcher;
import baseball.player.Umpire;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class PlayController {

    private final String INPUT_TEXT = "숫자를 입력해주세요 : ";
    private final String WIN_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String IS_GAME_OVER_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final String REPLAY_NUMBER = "1";
    private final List<String> PLAY_NUMBERS = Arrays.asList("1", "2");

    private StrikeZone strikeZone;
    private Umpire umpire;
    private Pitcher pitcher;

    public PlayController(){
        init();
    }

    public void init(){
        this.umpire = new Umpire();
        this.pitcher = new Pitcher();
    }

    public void playInit(){
        this.strikeZone = new StrikeZone();
    }

    public void play(){
        playInit();
        play(strikeZone.getZones());
    }

    public void play(List<Integer> zones){
        boolean isOut = false;
        while(!isOut){
            System.out.print(INPUT_TEXT);
            List<Integer> balls = pitcher.pitch();
            isOut = umpire.judge(zones, balls);
        }
        System.out.println(WIN_TEXT);
        chooseReplay();
    }

    public void chooseReplay(){
        System.out.println(IS_GAME_OVER_TEXT);
        String isReplay = validateIsReplay(Console.readLine());
        if(isReplay(isReplay))
            play();
    }

    public boolean isReplay(String chooseNumber){
        return REPLAY_NUMBER.equals(chooseNumber);
    }

    private String validateIsReplay(String isReplay) {
        if (!PLAY_NUMBERS.contains(isReplay))
            throw new IllegalArgumentException("must be 1 or 2");

        return isReplay;
    }
}
