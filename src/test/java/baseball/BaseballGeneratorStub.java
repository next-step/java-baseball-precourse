package baseball;

import java.util.List;

public class BaseballGeneratorStub implements BaseballGenerator {
    private final List<Integer> numbers;
    public BaseballGeneratorStub(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public List<Integer> Generate() {
        return numbers;
    }
}
