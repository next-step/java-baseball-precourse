package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    private List<Integer> numbers = new ArrayList<>();

    public Computer(){

    }

    public void init(){
        clearNumber();
        numbers = new ArrayList<>(getUniqueNumbersInRange(1,9,3));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Set<Integer> getUniqueNumbersInRange(int start, int end, int size){
        Set<Integer> set = new HashSet<>();
        while(set.size() < size){
            set.add(Randoms.pickNumberInRange(start, end));
        }
        return set;
    }

    public void clearNumber(){
        this.numbers.clear();
    }

}
