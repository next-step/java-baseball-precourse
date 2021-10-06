package baseball.model;


public class UserInputValue{
    private static final int INPUT_MAX_RANGE = 987;
    private static final int INPUT_MIN_RANGE = 123;
    private static final int PROPER_INPUT_LENGTH = 3;
    private static final int ZERO = 0;
    private static String errorCode = ""; 

    public static int getUserInput(String inputParam)  {
    	int userInputNumber = checkUserInput(inputParam);
        return userInputNumber;
    }
    
    public static String getErrCode() {
    	return errorCode;
    }

    /**
     * 메서드 checkUserInput()는 플레이어가 입력한 인풋이 1에서 9까지 중복되지 않는 3자리 수인지 검증
     * @param userInput 플레이어가 콘솔에 입력한 인풋
     * @return userInputNumber userInput이 유효한 3자리 숫자라고 판단하면 이를 정수로 변환해 반환
     */
    private static int checkUserInput(String userInput)  {
    	int userInputNumber = 0 ;
    	errorCode = "NORMER";
    	
        try {
        	userInputNumber = inputStringToInteger(userInput);
        	checkStringLength(userInput);
	        checkIntegerRange(userInputNumber);
	        checkIntegerDuplicate(userInputNumber);
	        checkIntegerHasZero(userInputNumber);
        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
        return userInputNumber; 
    }

    private static void checkStringLength(String userInput) {
        /* 3자리 인풋인지 확인한다 */
        if (userInput.length() != PROPER_INPUT_LENGTH) {
        	errorCode = "ERROR";
        	throw new IllegalArgumentException("[ERROR] 3자리 숫자를 입력해주세요.");
        }
    }

    private static int inputStringToInteger(String userInput) {
        /* 정수로 변환 될 수 있는지 확인한다 */
        int userInputNumber;
        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
        	errorCode = "ERROR";
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        return userInputNumber;
    }

    private static void checkIntegerRange(int userInputNumber) {
        /* 3자리 수인지 확인한다 */
        if(userInputNumber > INPUT_MAX_RANGE || userInputNumber < INPUT_MIN_RANGE) {
        	errorCode = "ERROR";
            throw new IllegalArgumentException("[ERROR] 123~987 사이값을 입력하세요.");
        }
    }

    private static void checkIntegerDuplicate(int userInputNumber)  {
        /* 3자리 수 중에서 중복이 있는지 확인한다 */
        int [] userDigits;
        userDigits = SeparateNumber.makeArray(userInputNumber);
        if((userDigits[0] == userDigits[1]) || (userDigits[0] == userDigits[2])
                || (userDigits[1] == userDigits[2])) {
        	errorCode = "ERROR";
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 3개 수를 입력해주세요.");
        }
    }

    private static void checkIntegerHasZero(int userInputNumber) {
        /* 3자리 수 중에서 0이 있는지 확인한다 */
        int [] userDigits;
        userDigits = SeparateNumber.makeArray(userInputNumber);
        if(userDigits[1] == ZERO || userDigits[2] == ZERO) {
        	errorCode = "ERROR";
            throw new IllegalArgumentException("[ERROR] 0을 제외한 숫자를 입력해주세요.");
        }
    }
}