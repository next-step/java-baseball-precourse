package baseball;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static List<Integer> comNum = new ArrayList<>();
    public static int strike;
    public static int ball;
    public static int nothing;
    public static int count;
    public static Controller controller = new Controller();
    public static View ui = new View();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.gameStart();
    }

}