package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Balls {

    private List<Ball> balls ;

    public Balls() {
        balls = new ArrayList<>();
    }

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public boolean composeOfDifferentNumbers() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < balls.size() ; i++) {
            hashMap.put(balls.get(i).getNumber(),i);
        }
        if ( hashMap.size() == balls.size()) {
            return  true;
        }
        return false;
    }


    public int size() {
        return balls.size();
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for(int i = 0 ; i < balls.size(); i++ ) {
           buf.append(balls.get(i).getNumber());
        }
        return buf.toString();
    }

    public int toInteger() {
        return Integer.parseInt(toString());
    }
}
