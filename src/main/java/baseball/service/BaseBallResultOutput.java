package baseball.service;

import static baseball.common.COMMON_MESSAGE.*;
import static baseball.domain.BaseBallNumbers.*;

import baseball.domain.BaseBallNumbers;
import baseball.domain.BaseBallNumbersResult;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallResultOutput {


	public void currentResult(BaseBallNumbers baseBallNumbers){
		BaseBallNumbersResult BaseBallNumbersResult= new BaseBallNumbersResult(baseBallNumbers);
		StringBuilder stringBuffer = getBallBuilder(BaseBallNumbersResult);
		stringBuffer.append(getStrikeBuilder(BaseBallNumbersResult));
		stringBuffer.append(getNothingBuilder(BaseBallNumbersResult));
		stringBuffer.append("\n");
		System.out.println(stringBuffer);
	}

	private StringBuilder getBallBuilder(BaseBallNumbersResult BaseBallNumbersResult) {
		StringBuilder stringBuffer = new StringBuilder();

		if(BaseBallNumbersResult.isExistBallCnt()){
			stringBuffer.append(BaseBallNumbersResult.getBallCnt()).append("볼 ");
		}
		return stringBuffer;
	}

	private StringBuilder getStrikeBuilder(BaseBallNumbersResult BaseBallNumbersResult) {
		StringBuilder stringBuffer = new StringBuilder();

		if(BaseBallNumbersResult.isExistStrikeCnt()){
			stringBuffer.append(BaseBallNumbersResult.getStrikeCnt()).append("스트라이크");
		}
		return stringBuffer;
	}

	private StringBuilder getNothingBuilder(BaseBallNumbersResult BaseBallNumbersResult) {
		StringBuilder stringBuffer = new StringBuilder();

		if(BaseBallNumbersResult.isNothing()){
			stringBuffer.append("낫싱");
		}
		return stringBuffer;
	}


}
