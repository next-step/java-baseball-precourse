package baseball;

import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
    	boolean play = true;
    	while(play) {
	    	String computerNum = selectThreeNums();
	    	//System.out.println(computerNum);
	    	
	    	playBaseball(computerNum);
	    	
	    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝\n"
	    				+ "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
	    	
	    	if(Console.readLine().equals("2")) {
		    		play = false;
		    	}
    	}
    }
    
    private static String selectThreeNums() {
    	int num1 = Randoms.pickNumberInRange(1, 9);
    	int num2 = 0;
    	int num3 = 0;
    	while((num2 = Randoms.pickNumberInRange(1, 9)) == num1) ;
    	while((num3 = Randoms.pickNumberInRange(1, 9)) == num1 || num3 == num2) ;
    	
    	return  String.valueOf(num1 * 100 + num2 * 10 + num3);
    }
    
    private static void playBaseball(String computerNum) {
    	boolean play = true;
    	
    	while(play) {
    		System.out.print("숫자를 입력해주세요 : ");
        	String playerNum = Console.readLine();
        	
        	//3 strike
        	if(compareNums(computerNum, playerNum) == 3) {
        		play = false;
        	}
    	}
    }
    
    private static int compareNums(String computerNum, String playerNum) {
    	int strike = 0;
    	int ball = 0;
    	
    	for(int i = 0; i < 3; i++) {
    		//computerNum에 player 숫자가 있는지 확인 
    		int idx = computerNum.indexOf(playerNum.charAt(i));
    		//System.out.println("idx : " + idx);
    		if(idx != -1 && idx == i) strike++;
    		if(idx != -1 && idx != i) ball++;
    		//System.out.println("strike : "+strike + ", ball : " + ball) ;
    	}
    	if(strike == 0 && ball == 0) System.out.println("낫싱");
    	if(strike > 0 || ball > 0) System.out.println((strike == 0 ? "" : strike + "스트라이크 ") + (ball == 0 ? "" : ball + "볼"));
    	
    	return strike;
    }
}
