package baseball;

public enum BBCODE {
    NT("낫싱",0,0),
    OB("1볼",1,0),
    TWB("2볼",2,0),
    THB("3볼",3,0),
    OS("1스트라이크",0,1),
    TWS("2스트라이크",0,2),
    THS("3스트라이크",0,3);

    public final String text;
    public final int ball;
    public final int strike;

    BBCODE(String text,int ball, int strike) {
        this.text = text;
        this.ball = ball;
        this.strike = strike;
    }

    public BBCODE getCode(int ball,int strike) {
        for(BBCODE code : BBCODE.values()) {
            if(code.strike == strike && code.ball == ball) {
                return code;
            }
        }
        return null;
    }
}
