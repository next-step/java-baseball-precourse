package baseball.vo;

public class SubmitBallNumberResponseVo {
	private String status;
	private GameResultVo gameResult;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GameResultVo getGameResult() {
		return gameResult;
	}

	public void setGameResult(GameResultVo gameResult) {
		this.gameResult = gameResult;
	}
}
