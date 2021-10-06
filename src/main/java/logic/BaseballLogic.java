package logic;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;
import ui.BaseballUi;

public class BaseballLogic {
	
	private BaseballUi ui;
	
	private String[] goals;
	
	private String[] inputs;
	
	private int[] results;
	
	public BaseballLogic(BaseballUi ui) {
		this.ui = ui;
	}
	
    // 문제 생성
    public void genGoals() {
    	List<String> goal = new ArrayList<>();
		do {
			String number = String.valueOf(Randoms.pickNumberInRange(1, 9));
			setGoalNumber(goal, number);
		} while (goal.size() < 3);
//		System.out.println("난수 : " + goal.get(0) + " " + goal.get(1) + " " + goal.get(2));
		this.goals = goal.toArray(new String[goal.size()]);
    }
    
    // 중복 제거후 숫자 입력
    private void setGoalNumber(List<String> goal, String number) {
    	if (!goal.contains(number)) {
    		goal.add(number);
    	}
    }
    
    // 사용자 입력
    public void inputNumbers() {
    	String[] inputs = ui.inputNumbers();
    	this.inputs = isValidInput(inputs) ? inputs : null;
    }
    
    // 결과 도출
    public void makeResult() {
    	if (getInputs() == null) {
    		return;
    	}
    	this.results = compares(getGoals(), getInputs());
    }
    
    // 숫자 비교
    private int[] compares(String[] goals, String[] inputs) {
    	int s = 0, b = 0;
    	for (int i = 0; i < goals.length; i++) {
    		s += (goals[i].equals(inputs[i])) ? 1 : 0;
    		b += getBallCount(goals[i], inputs, i);
    	}
    	return new int[] {s, b};
    }
    
    // 결과 출력
    public void printResult() {
    	if (getResults() == null) {
    		return;
    	}
    	ui.printResult(getResults());
    }
    
    private int getBallCount(String goal, String[] inputs, int index) {
    	int cnt = 0;
    	for (int i = 0; i < inputs.length; i++) {
    		cnt += (i != index && goal.equals(inputs[i])) ? 1 : 0;
    	}
    	return cnt;
    }
    
    // 종료여부
    public boolean checkAppEnd() {
    	return ui.inputGameEndYn().equals("2") ? false : true;
    }
    
    // 입력 validation
    private boolean isValidInput(String[] inputs) {
    	return isValidLength(inputs) && isValidNumbers(inputs) && isNoDupNumbers(inputs);
    }
    
    // 길이(3자리)
    private boolean isValidLength(String[] inputs) {
    	if (inputs.length != 3) {	// length : 3
    		ui.printValidLength();
    		return false;
    	}
    	return true;
    }
    
    // 숫자(1~9)
    private boolean isValidNumbers(String[] inputs) {
    	if (!canTranslateToNumber(inputs)) {
    		ui.printValidNumbers();
    		return false;
    	}
    	return true;
    }
    
    private boolean canTranslateToNumber(String[] inputs) {
    	boolean flag = true;
    	for (int i = 0; i < inputs.length; i++) {
    		char num = inputs[i].charAt(0);
    		flag = (num < '1' || '9' < num) ? false : flag; 
    	}
    	return flag;
    }
    
    // 중복 여부
    private boolean isNoDupNumbers(String[] inputs) {
    	boolean flag = true;
    	for (int i = 0; i < inputs.length - 1; i++) {
    		flag = (inputs[i].equals(inputs[i + 1])) ? false : flag;
    	}
    	if (!flag) {
    		ui.printNoDupNumbers();
    	}
    	return flag;
    }

	public String[] getGoals() {
		return goals;
	}

	public String[] getInputs() {
		return inputs;
	}
	
	public int[] getResults() {
		return results;
	}
    
}
