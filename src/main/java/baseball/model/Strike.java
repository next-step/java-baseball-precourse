package baseball.model;

public class Strike {
    private int count;

    public Strike() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void computeCount(int user, int computer){
        if(user == computer){
            this.count++;
        }
    }

    public Boolean isStrikeExisted(){
        if(this.count == 0){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
