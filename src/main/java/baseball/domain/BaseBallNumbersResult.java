package baseball.domain;

import java.util.function.Function;

public class BaseBallNumbersResult {
	private final BaseBallNumbers baseBallNumbers;

	private int ballCnt;
	private int strikeCnt;
	private int nothingCnt;
	Function<Boolean,Integer> trueThenCntUp = a->a?1:0;
	public BaseBallNumbersResult(BaseBallNumbers baseBallNumbers) {
		this.baseBallNumbers = baseBallNumbers;
		viewBallCnt();
		viewStrikeCnt();
		viewNotingCnt();
	}

	private void viewBallCnt(){
		Function<BaseBallNumber,Boolean> isBall = a->a.currentStatus().equals(Status.BALL);
		for(BaseBallNumber baseBall: baseBallNumbers.getList()){
			ballCnt += isBall.andThen(trueThenCntUp).apply(baseBall);
		}
	}

	private void viewStrikeCnt(){
		Function<BaseBallNumber,Boolean> isStrike = a->a.currentStatus().equals(Status.STRIKE);
		for(BaseBallNumber baseBall: baseBallNumbers.getList()){
			strikeCnt += isStrike.andThen(trueThenCntUp).apply(baseBall);
		}
	}

	private void viewNotingCnt(){
		Function<BaseBallNumber,Boolean> isNothing = a->a.currentStatus().equals(Status.NOTHING);
		for(BaseBallNumber baseBall: baseBallNumbers.getList()){
			nothingCnt += isNothing.andThen(trueThenCntUp).apply(baseBall);
		}
	}

	public boolean isExistBallCnt(){
		return getBallCnt()>0;
	}
	public boolean isExistStrikeCnt(){
		return getStrikeCnt()>0;
	}
	public boolean isNothing(){
		return getNothingCnt()==3;
	}
	public int getBallCnt() {
		return ballCnt;
	}
	public int getStrikeCnt() {
		return strikeCnt;
	}
	public int getNothingCnt() {
		return nothingCnt;
	}
}
