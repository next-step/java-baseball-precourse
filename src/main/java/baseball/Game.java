package baseball;

public class Game {

	public String judgment(BaseballNumbers player, BaseballNumbers computer) {
		int countOfSameNumber = player.countSameNumber(computer);
		int countOfStrike = player.countSameNumberAndLocation(computer);
		int countOfBall = countOfSameNumber - countOfStrike;

		if(countOfSameNumber == 0)
			return "낫싱";

		StringBuffer buffer = new StringBuffer();
		if(countOfStrike != 0){
			buffer.append(countOfStrike)
				.append("스트라이크");
		}

		if(countOfBall != 0){
			if(buffer.length() > 0){
				buffer.append(" ");
			}
			buffer.append(countOfBall)
				.append("볼");
		}
		return buffer.toString();
	}
}
