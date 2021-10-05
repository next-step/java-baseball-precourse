package baseball.model;

import nextstep.utils.Randoms;

import java.util.*;

public class AnswerNumbers {

    private static final int NUMBERS_LIST_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final List<Integer> numberList;

    public AnswerNumbers(String answerString) {
        validateOnlyNumber(answerString);
        validateThreeDigits(answerString);
        validateNotContainZero(answerString);
        validateNotContainDuplicateNumber(answerString);

        numberList = convertToNumberList(answerString);
    }

    private List<Integer> convertToNumberList(String numberString){
        List<Integer> convertedList = new ArrayList<>();
        String[] stringArray = numberString.split("");

        for(int i=0; i< stringArray.length; i++){
            convertedList.add(Integer.parseInt(stringArray[i]));
        }
        return convertedList;
    }

    public AnswerNumbers() {
        this.numberList = generateRandomNumbers();
    }

    private static List<Integer> generateRandomNumbers () {
        Set<Integer> numberList = new LinkedHashSet<>();

        while(numberList.size() < NUMBERS_LIST_SIZE){
            numberList.add(Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER));
        }

        return new ArrayList<>(numberList);
    }


    private void validateOnlyNumber(String askAnswer){
        try{
            Integer.parseInt(askAnswer);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 1~9 외 다른 문자는 유효하지 않습니다.");
        }
    }

    private void validateThreeDigits(String askAnswer){
        if(askAnswer.length() > 3 || askAnswer.length()< 3){
            throw new IllegalArgumentException("[ERROR] 3자리로 입력해주세요.");
        }
    }

    private void validateNotContainZero(String askAnswer){
        if(askAnswer.contains("0")){
            throw new IllegalArgumentException("[ERROR] 숫자는 \"0\"을 포함할 수 없습니다.");
        }
    }

    private void validateNotContainDuplicateNumber(String askAnswer){
        Set<String> numberSet = new HashSet<>(Arrays.asList(askAnswer.split("")));
        if(numberSet.size() != NUMBERS_LIST_SIZE){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    public CheckResult checkAnswer(AnswerNumbers askAnswer) {
        List<Integer> askAnswerList = askAnswer.getNumberList();
        int strikeCount=0, ballCount=0;
        for(int i=0; i<numberList.size(); i++){
            strikeCount += countStrike(askAnswerList,i);
            ballCount += countBall(askAnswerList,i);
        }
        return new CheckResult(strikeCount, ballCount);
    }

    private int countStrike(List<Integer> askAnswerList, int index){
        if (askAnswerList.get(index) == numberList.get(index)) {
            return 1;
        }
        return 0;
    }

    private int countBall(List<Integer> askAnswerList, int index){
        int number = askAnswerList.get(index);
        if(number != numberList.get(index) && numberList.contains(number)){
            return 1;
        }
        return 0;
    }


    public List<Integer> getNumberList() {
        return numberList;
    }
}
