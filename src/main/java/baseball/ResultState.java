package baseball;

public enum ResultState {
    BOLL(0),
    STRIKE(1);

    private int value;

    ResultState(int value){
        this.value = value;
    }

    public int getValue() { return  this.value; }
}
