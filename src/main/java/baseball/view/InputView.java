package baseball.view;

import nextstep.utils.Console;

public class InputView {
		
	public static String getInput() {
//		return scanInput();
		return scanInput();
		//return this.inpuValue;
	}
	
	private static String scanInput() {
		System.out.print("숫자를 입력해주세요 !! : ");
		return Console.readLine();
	}
	
//
//	private static String scanInput() {
//		System.out.print("숫자를 입력해주세요 !! : ");
//		String inputVar = Console.readLine();
//		System.out.println("모재윤 테스트 inputVar == " + inputVar);
//		
//		try {
//			if(chkNumber(inputVar) == 0) {
//				throw new IllegalArgumentException("[ERROR] 숫자만 입력하실 수 있습니다.");
//			}
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return inputVar; 
//	}
//	
//	
//	/**
//	 * 입력받은 값이 숫자만으로 구성되어 있는지 확인 한다.
//	 * @param inputvalue
//	 * @return 0:숫자아닌문자포함, 1:숫자 
//	 */
//	private static int chkNumber(String inputParam) {
//		int chkNumberFlag = 0;
//		
//		boolean isNumber = inputParam.matches("[+-]?\\d*(\\.\\d+)?");
//		if(isNumber) {
//			chkNumberFlag = 1;
//		}
//		return chkNumberFlag;
//	}
	
	

}
