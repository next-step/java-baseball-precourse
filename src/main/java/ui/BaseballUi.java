package ui;

import nextstep.utils.Console;

public class BaseballUi {
	
	// 사용자 입력
	public String[] inputNumbers() {
		System.out.print("숫자를 입력해 주세요 : ");
		String input = Console.readLine();
		return input.split("");
	}
	
    public void printResult(int[] result) {
    	printStrikeout(result);
    	printNothing(result);
    	printStrikeAndBall(result);
    }
    
    private void printStrikeout(int[] result) {
    	if (result[0] != 3) {				// 3스트라이크
    		return;
    	}
    	System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
    
    private void printNothing(int[] result) {
    	if (result[0] + result[1] != 0) {	// 낫싱
    		return;
    	}
    	System.out.println("낫싱");
    }
    
    private void printStrikeAndBall(int[] result) {
    	if (result[0] == 3 || result[0] + result[1] == 0) {
    		return;
    	}
    	String st = (result[0] > 0) ? result[0] + "스트라이크 " : "";
		String bl = (result[1] > 0) ? result[1] + "볼" : "";
		System.out.println(st + bl);
    }
    
    // 다음 게임 여부 확인
    public String inputGameEndYn() {
    	String input = "";
    	do {
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    		input = Console.readLine();
    	} while (!("1".equals(input) || "2".equals(input)));
    	return input;
    	
    }
    
    public void printValidLength() {
    	System.out.println("3자리만 입력 가능합니다.");
    }
    
    public void printValidNumbers() {
    	System.out.println("숫자만 입력 가능합니다.(1 ~ 9)");
    }
    
    public void printNoDupNumbers() {
    	System.out.println("중복된 숫자는 입력할 수 없습니다.");
    }
    
}