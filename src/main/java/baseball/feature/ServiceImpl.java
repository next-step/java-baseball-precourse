package baseball.feature;

import baseball.domain.CheckResult;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiceImpl implements Service{

    private final int MAX_ADD_COUNT = 6;

    @Override
    public CheckResult getCheckResult(Integer[] answer, Integer[] inputNums) {
        Set<Integer> ballCheckSet = new HashSet<>();
        int strikeCount = 0;

        for (int i = 0; i < answer.length; i++) {
            strikeCount += checkStrike(answer[i], inputNums[i], ballCheckSet);
        }

        int addCount = MAX_ADD_COUNT - (strikeCount*2);
        int ballCount = addCount - ballCheckSet.size();

        return new CheckResult(strikeCount, ballCount);
    }


    //입력값 유효성 검사
    @Override
    public boolean isValid(String input) {
        //3자리수로 입력되었는지?
        if(input.trim().length() != 3){
            return false;
        }
        //전부 숫자로 입력되었는지?
        try {
            int number = Integer.valueOf(input);
        }catch (NumberFormatException e){
            return false;
        }

        //중복입력이 있는지?
        if(checkDuplicate(input)){
            return false;
        }

        return true;
    }

    //정답 생성하기
    @Override
    public Integer[] makeRandomDigit(int num){
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3){
            checkAndAddNumbers(list, Randoms.pickNumberInRange(1,9));
        }
        return list.toArray(new Integer[0]);
    }


    //String to int
    @Override
    public Integer[] stringToInt(String input) {
        Integer[] result = new Integer[input.length()];
        String[] digits = input.split("");

        for (int i = 0; i < digits.length ; i++) {
            result[i] = Integer.valueOf(digits[i]);
        }
        return result;
    }


    //스트라이크 카운트
    private int checkStrike(Integer answer, Integer inputNum, Set<Integer> ballCheck) {
        int count = 0;
        //동일하면 스트라이크 +
        if(answer == inputNum){
            count = 1;
        }
        //다르면 볼카운트 체크를 위해 셋에 추가
        if(answer != inputNum){
            ballCheck.add(answer);
            ballCheck.add(inputNum);
        }
        return count;
    }


    private boolean checkDuplicate(String input){
        HashSet<String> checkDulicate = new HashSet<>();
        String[] digits = input.split("");

        for (int i = 0; i < digits.length ; i++) {
            checkDulicate.add(digits[i]);
        }

        if(checkDulicate.size()<3){
            return true;
        }

        return false;
    }

    private void checkAndAddNumbers(List<Integer> list, int random){
        if(!list.contains(random)){
            list.add(random);
        }
    }


}
