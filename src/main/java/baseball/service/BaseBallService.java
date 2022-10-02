package baseball.service;

import static baseball.common.COMMON_MESSAGE.*;
import static baseball.domain.BaseBallNumbers.*;

import baseball.domain.BaseBallNumbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallService {

	private Process process;
	private boolean isAlive;
	private String outputText;
	private BaseBallNumbers computerNumbers;
	private final BaseBallResultOutput baseBallResultOutput;
	public boolean isAlive() {
		return isAlive;
	}

	public interface Process{
		Process run(String input);
	}

	public BaseBallService(){
		gameInit();
		process = guessTheNumber();
		baseBallResultOutput = new BaseBallResultOutput();
	}

	public void processRun(){
		String input = Console.readLine();
		process = process.run(input);
	}

	private Process gameEndOrContinue(String input) {
		if("1".equals(input)){
			gameInit();
			return guessTheNumber();
		}
		if("2".equals(input)){
			isAlive = false;
		}
		return null;
	}

	private void gameInit(){
		isAlive = true;
		computerNumbers = createComputeNumber();
	}

	private BaseBallNumbers convertBaseBallNumbersFrom(String input){
		if(input.isEmpty()){
			throw new IllegalArgumentException("not empty");
		}
		return createBaseBallNumbers(input);
	}

	private Process guessTheNumber(){
		outputText = REQUEST_NUMBER;
		return input->{
			BaseBallNumbers baseBallNumbers = convertBaseBallNumbersFrom(input);
			return resultOutPut(baseBallNumbers);
		};
	}

	private Process resultOutPut(BaseBallNumbers baseBallNumbers) {
		if(baseBallNumbers.isSuccessCatching(computerNumbers)){
			baseBallResultOutput.currentResult(baseBallNumbers);
			outputText = COMPLETE;
			return this::gameEndOrContinue;
		}
		baseBallResultOutput.currentResult(baseBallNumbers);
		return guessTheNumber();
	}

	public void viewingOutputText(){
		System.out.print(outputText);
	}

}
