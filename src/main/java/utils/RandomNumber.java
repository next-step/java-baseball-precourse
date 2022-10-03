package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private int[] randomNumber;
    private int size;
    private int startNumber;
    private int endNumber;


    public RandomNumber(int size, int startNumber, int endNumber) {
        this.size = size;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public int[] getRandomNumber() {
        randomNumber = new int[size];
        for(int i =0; i< size; i++){
            randomNumber[i] = getNumber(randomNumber,i,startNumber,endNumber);
        }
        return randomNumber;
    }

    private int makeNumber(int startNumber, int endNumber){
        return Randoms.pickNumberInRange(startNumber,endNumber);
    }

    private int getNumber(int[] randomNumber,int index,int startNumber, int endNumber){
        int findNumber = makeNumber(startNumber,endNumber);
        while(!checkUnique(index,randomNumber,findNumber)){
            findNumber = makeNumber(startNumber,endNumber);
        }
        return findNumber;
    }
    private boolean checkUnique(int index,int[] randomNumber, int findNumber){

        for(int i =0;i<index;i++){
            if (randomNumber[i] == findNumber){
                return false;
            }
        }
        return true;
    }
}
