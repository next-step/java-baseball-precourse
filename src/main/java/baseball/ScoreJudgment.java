package baseball;

import java.util.List;

public class ScoreJudgment {
	public int countSameNumber(List<Integer> playerNumbers, List<Integer> computerNumbers) {
		int count = 0;
		for (int index = 0; index < playerNumbers.size(); index++) {
			int number = playerNumbers.get(index);
			if(computerNumbers.contains(number)){
				count++;
			}
		}
		return count;
	}

	public int countSameNumberAndLocation(List<Integer> playerNumbers, List<Integer> computerNumbers) {
		int count = 0;
		for (int index = 0; index < playerNumbers.size(); index++) {
			int number = playerNumbers.get(index);
			if(computerNumbers.get(index) == number){
				count++;
			}
		}
		return count;
	}
}
