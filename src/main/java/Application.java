public class Application {
    private final static int END_VALUE=2;
    private static InputView input = new InputView();
    private static OutputView output=new OutputView();
    public static void main(String[] args){
        boolean play=true;
        while(play){
            GameController game=new GameController();
            while(!game.isEnded()){
                game.playTurn();
            }
            output.printAnswerSituation();
            if(input.getRestartOrEnd()==END_VALUE){
                play=false;
            }
        }
    }
}
