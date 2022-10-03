package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.NumMessage;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballComputer {
	
	private List<Integer> randNewNumbers;
	private boolean end;
	private int strikeCount;
	private int ballCount;

	public BaseballComputer() {
		this.randNewNumbers = makeRandomNumbers();
		this.end = false;
	}
	
	public List<Integer> getRandomNumbers() {
		return randNewNumbers;
	}
	
	public boolean isEnd() {
		return end;
	}
	
	public int getStrikeCount() {
		return strikeCount;
	}
	
	public int getBallCount() {
		return ballCount;
	}
	
	private List<Integer> makeRandomNumbers() {
		List<Integer> randNewNumbers = new ArrayList<>();
		while (randNewNumbers.size() < NumMessage.NUM_LENGTH) {
			randNewNumbers.add(makeRandomNumber(randNewNumbers));
		}
		return randNewNumbers;
	}
	
	private int makeRandomNumber(List<Integer> randNewNumbers) {
		int num = Randoms.pickNumberInRange(NumMessage.RANDOM_MIN_NUM,NumMessage.RANDOM_MAX_NUM);
		while (randNewNumbers.contains(num)) {
			num = Randoms.pickNumberInRange(NumMessage.RANDOM_MIN_NUM,NumMessage.RANDOM_MAX_NUM);
		}
		return num;
	}
	
	public void checkInput(List<Integer> inputNumbers) {
		strikeCount = ballCount = 0;
		
		for(int i = 0; i < NumMessage.NUM_LENGTH; i++) {
			updateState(inputNumbers.get(i), i);
		}
		if(strikeCount == NumMessage.NUM_LENGTH){
			end = true;
		}
	}
	
	public void updateState(Integer num, int idx) {
		if(randNewNumbers.get(idx) == num) {
			strikeCount++;
			return;
		}
		if(randNewNumbers.contains(num)) {
			ballCount++;
			return;
		}
	}

}