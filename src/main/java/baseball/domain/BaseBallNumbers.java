package baseball.domain;

import static baseball.common.COMMON_CONSTANT.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class BaseBallNumbers {

	final List<BaseBallNumber> baseBallNumbers;

	public BaseBallNumbers(List<BaseBallNumber> baseBallNumbers) {

		Optional.ofNullable(baseBallNumbers).orElseThrow(()->new IllegalArgumentException("must input value"));
		if(baseBallNumbers.size()>NUMBER_RANGE){
			throw new IllegalArgumentException("must length 3");
		}
		this.baseBallNumbers = baseBallNumbers;
	}

	public List<BaseBallNumber> getList(){
		return baseBallNumbers;
	}

	public static BaseBallNumbers createComputeNumber(){
		return createNumber(new RandomMachine().getNumber());
	}

	public static BaseBallNumbers createBaseBallNumbers(String input) {
		String[] inputs = input.split("");
		List<Integer> baseballNumbers = new ArrayList<>();
		for(String str : inputs){
			baseballNumbers.add(Integer.valueOf(str));
		}
		return createNumber(baseballNumbers);
	}

	public static BaseBallNumbers createNumber(List<Integer> baseBallRandomNumbers){
		List<BaseBallNumber> baseBallMeNumbers = new ArrayList<>();
		for(int i = 0;i<baseBallRandomNumbers.size();i++){
			baseBallMeNumbers.add(BaseBallNumber.of(i+1,baseBallRandomNumbers.get(i)));
		}
		return new BaseBallNumbers(baseBallMeNumbers);
	}

	public boolean isSuccessCatching(BaseBallNumbers computerNumber){
		Consumer<BaseBallNumber> baseBallNumberConsumer = b -> this.analysis(a -> a.updateBallCount(b));
		computerNumber.analysis(baseBallNumberConsumer);
		return this.threeStrike();
	}

	private boolean threeStrike(){
		int ballCount = 0;
		for(BaseBallNumber baseBallNumber: baseBallNumbers){
			ballCount += getBallCount(baseBallNumber);
		}
		if(isComplete(ballCount)){
			return COMPLETE;
		}
		return FAIL;
	}

	private int getBallCount(BaseBallNumber baseBallNumber) {
		if(baseBallNumber.isCurrentStrike()){
			return 1;
		}
		return 0;
	}

	private boolean isComplete(int ballCount) {
		return NUMBER_RANGE == ballCount;
	}

	private void analysis(Consumer<BaseBallNumber> consumer){
		this.baseBallNumbers.forEach(consumer);
	}

	@Override
	public String toString() {
		return "BaseBallNumbers{" +
			"baseBallMeNumbers=" + baseBallNumbers +
			'}';
	}


}
