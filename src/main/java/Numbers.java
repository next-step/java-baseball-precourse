import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;
    public Numbers(){
        this.numbers= generateNumbers();
    }
    private static final int DIGIT_NUMBER = 3;
    private List<Integer> generateNumbers() {
        List<Integer> answer = new ArrayList<>();
        NumberGenerator numberGenerator = new NumberGenerator();
        while(answer.size()!=DIGIT_NUMBER){
            int num = numberGenerator.generateNumber();
            if (!answer.contains(num)) {
                answer.add(num);
            }
        }
        return answer;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
