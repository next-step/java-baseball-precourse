package baseball;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();
        Game game = new Game();
        game.start(player,computer);
    }
}
