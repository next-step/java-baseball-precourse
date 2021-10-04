package baseball;

public class result_sol(int strike_count, int input_value) {
	
	if(strike_count==3) {
		System.out.println("게임을 계속하시려면 1을, 종료하시려면 다른 키를 입력해 주세요");
		if(input_value==1) return 1;
		System.out.println("Goodbye");
		return 0;

}
