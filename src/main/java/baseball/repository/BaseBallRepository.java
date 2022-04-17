package baseball.repository;

import java.util.List;

public class BaseBallRepository {

    private final ThreadLocal<List<Integer>> answer = new ThreadLocal<>();

    public void initAnswer(List<Integer> answer) {
        this.answer.set(answer);
    }

    public List<Integer> getAnswer() {
        return answer.get();
    }
}
