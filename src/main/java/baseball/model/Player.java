package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Constant.*;

public class Player {
    private final List<Integer> numbers = new ArrayList<>(INPUT_SIZE);

    public Player(String input) {
        tokenizeAndAddInput(input);
    }

    private void tokenizeAndAddInput(String input){
        validate(input);

        for(int i = 0; i < input.length(); i++){
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private void validate(String input){
        for(int i = 0; i < input.length(); i++){
            if(!isDuplicate(input.charAt(i), input)){
                throw new IllegalArgumentException(ERROR_DUPLICATED_INPUT);
            }
        }

        if (input.length() > INPUT_SIZE) {
            throw new IllegalArgumentException(ERROR_EXEEDING_INPUT_SIZE);
        }

        if(input.length() < INPUT_SIZE){
            throw new IllegalArgumentException(ERROR_LESS_THAN_INPUT_SIZE);
        }
    }

    private boolean isDuplicate(char input, String fullInput){
        int count = 0;
        for(int i = 0; i < fullInput.length(); i++){
            if(input == fullInput.charAt(i)){
                count++;
            }
        }
        return count <= 1;
    }

    public int getSize(){
        return numbers.size();
    }

    public int getValue(int index){
        return numbers.get(index);
    }
}
