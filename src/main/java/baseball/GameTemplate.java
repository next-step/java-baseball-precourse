package baseball;

public abstract class GameTemplate {
    public abstract void start();
    public abstract void play();
    public abstract boolean end();

    public final boolean run(){
        start();
        play();
        return end();
    }
}
