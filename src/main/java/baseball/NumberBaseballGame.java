package baseball;

public class NumberBaseballGame {

    private boolean play;
    private final int maxNumberLength;

    public NumberBaseballGame(int maxNumberLength){
        this.maxNumberLength = maxNumberLength;
    }

    private void setUp(){
    }

    public boolean isPlay() { return this.play; }

    public boolean playing(String number) throws IllegalArgumentException{
        return true;
    }

    private int[] numberValidation(String number){
        int[] result = new int[ResultState.values().length+1];
        return result;
    }


    private void printResult(int[] result){

    }

    public boolean restart(){
        return true;
    }

    public void gameOver(){
    }
}
