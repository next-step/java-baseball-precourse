package baseball.service;

public interface Referee<Player, Result> {

    void checkCommand(String command);

    Result compareNumber(Player player1, Player player2);
}
