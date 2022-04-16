package baseball.model;

import java.util.List;

public class Ball {
    private int count;

    public Ball() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void computeCount(List<Integer> userNumbers, List<Integer> computerNumbers){
        for(int i=0; i<userNumbers.size(); i++){
            isBall(userNumbers.get(i), i, computerNumbers);
        }
    }

    private void isBall(int userNumber, int userIndex, List<Integer> computerNumbers){
        if(computerNumbers.indexOf(userNumber) != userIndex){
            this.count++;
        }
    }

    public Boolean isBallExisted(){
        if(this.count == 0){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
