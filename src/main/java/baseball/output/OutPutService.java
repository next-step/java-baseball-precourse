package baseball.output;

public class OutPutService {

    private OutPut outPut;

    public OutPutService() {
        this.outPut = new OutPut();
    }

    public void printGameMessage() {
        System.out.println(outPut.getGameMessage());
    }

    public void printRestartMessage() {
        System.out.println(outPut.getRestartMessage());
    }
}
