package baseball;

public class Application {
  public void run() {
    boolean switchOn = true;
    BaseballMachine machine = BaseballMachine.getInstance();

    while (switchOn) {
      machine.play();
      switchOn = machine.isContinued();
    }
  }

  public static void main(String[] args) {
    Application app = new Application();
    app.run();
  }
}
