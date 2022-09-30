package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * author : hyeongju
 * date : 2022.09.28
 * description :
 */
public class Computer {

    String correctAnswer;

    public Computer(){
        correctAnswer = generateTreeNumber();
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * 중복없는 3자리 숫자를 생성한다
     * @return numbers 중복없는 숫자 3자리
     */
    public static String generateTreeNumber() {
        String nums = "";
        while (nums.length() < 3){
            String num = Integer.toString(Randoms.pickNumberInRange(1, 9));
            nums += containsNumber(nums, num);
        }

        return nums;
    }

    public static String containsNumber(String nums, String num){
        if(!nums.contains(num)){
            return num;
        }
        return "";
    }

}
