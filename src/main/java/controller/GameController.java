package controller;

import camp.nextstep.edu.missionutils.Console;
import service.GameService;
import view.SystemMessage;

public class GameController {
    private int size;
    private int startNumber;
    private int endNumber;

    final String rePlay = "1";
    final String endPlay = "2";
    SystemMessage systemMessage = new SystemMessage();
    GameService gameService;

    public GameController(int size, int startNumber, int endNumber) {
        this.size = size;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        gameService = new GameService(size,startNumber,endNumber);
    }


    public void run() throws IllegalArgumentException {
        gameService.setGame();
        gameService.playGame();
        endgame();
    }

    private void endgame() throws IllegalArgumentException{
        systemMessage.getEndMessage();
        String input = Console.readLine();
        if(rePlay.equals(input)){
            run();
        }
        if(!rePlay.equals(input) && !endPlay.equals(input)){
            throw new IllegalArgumentException();
        }
    }

}
