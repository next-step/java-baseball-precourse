package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nextstep.utils.Randoms;

public class BaseballModel implements Model{

    private GameStatus gameStatus;
    private int size;
    private List<Integer> randomNumber;
    private Map<String, Integer> result = new HashMap<>();

    public BaseballModel() {
        this.gameStatus = GameStatus.BEFORE_START;
    }

    /**
     * 중복되지 않는 랜덤한 번호를 생성한다
     */
    public void generateRandomNumber(){
        this.randomNumber = new ArrayList<>(size);
        while (randomNumber.size() < size){
            pickNumber();
        }
    }

    private void pickNumber() {
        int number = Randoms.pickNumberInRange(1, 9);
        if( randomNumber.contains(number)){
            return;
        }
        randomNumber.add(number);
    }

    public String getRandomNumber() {
        String str = "";
        for(Integer number : randomNumber){
            str += number;
        }
        return str;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public int getSize() {
        return size;
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    /**
     * 스트라이크-볼 판정
     * @param answer
     * @return strike ball count map
     * @throws IllegalArgumentException
     */
    public Map<String, Integer> challenge(String answer) throws IllegalArgumentException{
        validateAnswer(answer);
        result = new HashMap<>();
        for(int i=0; i<size; i++) {
            int num = Integer.parseInt(String.valueOf(answer.charAt(i)));
            if(randomNumber.contains(num)){
                String key = strikeBall(num, i);
                result.put(key, result.getOrDefault(key, 0) + 1);
            }
        }
        if(result.getOrDefault("STRIKE", 0) == size)
            this.gameStatus = GameStatus.STAGE_END;
        return result;
    }

    private String strikeBall(int num, int index) {
        if(this.randomNumber.indexOf(num) == index)
            return "STRIKE";
        return "BALL";
    }

    private void validateAnswer(String answer) {
        if(answer == null || answer.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력된 내용이 없습니다");
        if(answer.length() != size)
            throw new IllegalArgumentException("[ERROR] 입력값의 크기가 일치하지 않습니다");
        if(answer.chars().anyMatch(e -> e == '0'))
            throw new IllegalArgumentException("[ERROR] 0은 입력할 수 없습니다");
        if(!answer.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다");

        validateNumberDuplicate(answer);
    }

    private void validateNumberDuplicate(String answer) {
        char[] arr = answer.toCharArray();
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1])
                throw new IllegalArgumentException("[ERROR] 중복된 값을 입력하였습니다");
        }
    }

    public void startStage(int size) {
        this.size = size;
        this.generateRandomNumber();
        this.gameStatus = GameStatus.STAGE_START;
    }

    public void continueGame(String answer) {
        validateContinueGameAnswer(answer);
        this.gameStatus = GameStatus.GAME_OVER;
        if(answer.equals("1")) {
            this.gameStatus = GameStatus.BEFORE_START;
        }
    }

    private void validateContinueGameAnswer(String answer) {
        if(answer == null || answer.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력된 내용이 없습니다");
        if(!answer.equals("1") && !answer.equals("2")){
            throw new IllegalArgumentException("[ERROR] 옳바르지 않은 값입니다");
        }
    }
}
