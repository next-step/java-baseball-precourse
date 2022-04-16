package baseball.core.player;


import java.util.Map;
import org.junit.jupiter.api.Test;

public class PitcherTest {

    @Test
    void pitcherCreateTest(){
        TestPitcherRepository pitcher = new TestPitcherRepository();

        pitcher.pitching();
        for(Map.Entry<Integer, Integer> entry: pitcher.pitch.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("===============================");
        pitcher.pitching();
        for(Map.Entry<Integer, Integer> entry: pitcher.pitch.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
