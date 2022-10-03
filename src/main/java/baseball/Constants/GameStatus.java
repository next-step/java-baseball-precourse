package baseball.Constants;

public enum GameStatus {

    START(1),
    END(2);

    private final int value;

    GameStatus(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public static GameStatus searchKey(int value){
        for(GameStatus gameStatus : GameStatus.values()){
            if(gameStatus.getValue() == value){
                return gameStatus;
            }
        }
        throw new IllegalArgumentException("there is no matching enum");
    }

}
