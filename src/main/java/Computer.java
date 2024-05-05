import java.util.ArrayList;
import java.util.List;

public class Computer {
    final static int NUM_LENGTH = 3;

    /**
     * 랜덤값을 생성하고 랜덤값 List 반환 메서드
     * @return
     */
    public static List<Integer> createRandomNum(){
        int randNum;
        List<Integer> cpuNum =new ArrayList<>();

        while (cpuNum.size() < NUM_LENGTH) {
            randNum = (int)(Math.random() * 9 +1);
            if(!cpuNum.contains(randNum)){
                cpuNum.add(randNum);
            }

        }
        return cpuNum;
    }
}
