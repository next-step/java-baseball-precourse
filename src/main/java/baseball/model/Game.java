package baseball.model;

public class Game {

	private static Game instance;
	private String goal;

	private Game() {
	}

	public static Game getInstance() {
		if (instance == null) {
			synchronized (Game.class) {
				instance = new Game();
			}
		}
		return instance;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
}