package baseball.domain;

import camp.nextstep.edu.missionutils.Console;


public class Player {
    private Player(){
    }


    public static Player createPlayer(){
        return new Player();
    }


    public String enterNumber(){
        try {
            String playerInputNumber= Console.readLine();
            return playerInputNumber;
        }
        catch(Exception e){
            return null;
        }
    }
}
