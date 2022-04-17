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
            return Console.readLine();
        }
        catch(Exception e){
            return null;
        }
    }
}
