package service;

import camp.nextstep.edu.missionutils.Console;
import domain.Game;
import domain.Player;
import view.GameMessage;
import utils.RandomNumber;
import utils.SplitNumber;

public class GameService {
    Game game;
    Player player = new Player();

    private int size;
    private int startNumber;
    private int endNumber;
    SplitNumber splitNumber;
    GameMessage gameMessage = new GameMessage();
    public GameService(int size, int startNumber, int endNumber) {
        this.size = size;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public void setGame(){
        RandomNumber randomNumber =
                new RandomNumber(size,startNumber,endNumber);
        this.game = new Game(randomNumber.getRandomNumber());
    }
    public void playGame() throws IllegalArgumentException {
        while (game.getStrikeCount() != 3){
            gameMessage.getNumberMessage();
            game.initGame();
            player.setPlayerNumber(getPlayerNumber());
            decideScore();
            gameMessage.scoreMessage(game.getBallCount(), game.getStrikeCount());
        }
        gameMessage.endGameMessage();
    }
    private int[] getPlayerNumber() throws IllegalArgumentException {
        String input = Console.readLine();
        splitNumber = new SplitNumber(input,size);
        return splitNumber.getSplitNumbers();
    }
    private void decideScore(){
        for(int i= 0 ;i < size ; i++){
            isStrike(i,game.getGameNumber()[i],player.getPlayerNumber()[i]);
            isBall(i,game.getGameNumber()[i],player.getPlayerNumber());
        }
    }
    private void isStrike(int index, int gameNumber, int playerNumber){
        if(gameNumber == playerNumber){
            game.setStrikeCount(game.getStrikeCount()+1);
        }
    }

    private void isBall(int index, int gameNumber, int[] playerNumber){
        for(int i = 0; i< size; i++){
            if(i!=index && gameNumber == playerNumber[i]){
                game.setBallCount(game.getBallCount()+1);
                break;
            }
        }
    }
}
