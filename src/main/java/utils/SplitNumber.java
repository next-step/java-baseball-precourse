package utils;

public class SplitNumber {
    private String number;
    private int size;
    private int[] splitNumbers;
    public SplitNumber(String number, int size) {
        this.number = number;
        this.size = size;
    }

    public int[] getSplitNumbers() throws IllegalArgumentException {

        if(number.length() != size){
            throw new IllegalArgumentException();
        }
        if(!number.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException();
        }
        splitNumbers = splitFunction(number);
        return splitNumbers;
    }

    private int[] splitFunction(String number){
        int[] splitNumber = new int[size];
        for(int i = 0; i< size; i++){
            splitNumber[i] = number.charAt(i)-'0';
        }
        return splitNumber;
    }
}
