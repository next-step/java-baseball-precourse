package baseball.model;

import java.util.Map;

/**
 * 게임 플레이어와 컴퓨터간 게임
 */
public class Game {

    private final Computer computer;
    private final GamePlayer gamePlayer;

    public Game(Computer computer, GamePlayer gamePlayer) {
        this.computer = computer;
        this.gamePlayer = gamePlayer;
    }

    public GameResult getGameResult() {
        Map<Integer, Integer> gamePlayerNumbers = gamePlayer.getNumber();
        int strike = 0;
        int totalMatch = 0;
        for(Integer gamePlayerDigit: gamePlayerNumbers.keySet()) {
            strike += checkStrike(gamePlayerDigit);
            totalMatch += checkContainDigit(gamePlayerDigit); // 위치 상관없이 동일한 값 있는지 확인
        }
        return new GameResult(strike, totalMatch - strike);
    }

    /**
     * 게임 플레이어의 한자리 숫자가 컴퓨터의 숫자 내 동일한 위치에 존재하는지 확인
     * @param gamePlayerDigit
     * @return 동일한 위치에 존재한다면 1 반환, 그 외 0 반환
     */
    private int checkStrike(Integer gamePlayerDigit) {
        if(checkContainDigit(gamePlayerDigit) == 1) {
            return checkMatchDigitLocation(gamePlayerDigit);
        }
        return 0;
    }

    /**
     * 게임 플레이어의 한자리 숫자가 컴퓨터의 숫자 내에 존재하는지 확인
     * @param gamePlayerDigit
     * @return 컴퓨터의 숫자 내에 존재할 경우 1 반환, 컴퓨터의 숫자 내에 존재하지 않을 경우 0 반환
     */
    private int checkContainDigit(Integer gamePlayerDigit) {
        Map<Integer, Integer> computerNumber = computer.getNumber();
        if(!computerNumber.containsKey(gamePlayerDigit)) {
            return 0;
        }
        return 1;
    }

    /**
     * 특정 한자리 숫자의 위치가 게임 플레이어와 컴퓨터간에 동일한지 확인
     * @param gamePlayerDigit
     * @return 동일할 경우 1 반환, 동일하지 않을 경우 0 반환
     */
    private int checkMatchDigitLocation(Integer gamePlayerDigit) {
        Map<Integer, Integer> computerNumbers = computer.getNumber();
        Map<Integer, Integer> gamePlayerNumbers = gamePlayer.getNumber();
        Integer gamePlayerDigitIdx = gamePlayerNumbers.get(gamePlayerDigit);
        Integer computerDigitIdx = computerNumbers.get(gamePlayerDigit);
        if(gamePlayerDigitIdx.equals(computerDigitIdx)) {
            return 1;
        }
        return 0;
    }
}
