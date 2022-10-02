package baseball.game;

public class BaseBallGame {

    Context context = new Context();

    public void start(){

        while (context.isPlay()) {
            context.command();
        }
    }
}
