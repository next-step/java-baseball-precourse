package baseball.domain;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public class Gamer {

	public final static int BALL_COUNT_LENGTH = 3;
	private Integer[] balls;


	public Gamer(Integer[] balls) {
		this.balls = new Integer[BALL_COUNT_LENGTH];
		this.balls = balls;
	}

	public Integer[] getBalls() {
		return balls;
	}

}
