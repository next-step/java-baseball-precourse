package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Pitcher implements Rule {
    private Set<Integer> questionValue;
    private String inputValue;

    public Pitcher() {
        setQuestionValue(new LinkedHashSet<>());
    }

    public void generateRandomValue() {
        getQuestionValue().clear();

        do {
            getQuestionValue().add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        } while(getQuestionValue().size() < LIMIT_NUMBER);

        setInputValue(getQuestionValue().toString().replaceAll("[^" + START_NUMBER + "-" + END_NUMBER + "]", ""));
    }

    public Set<Integer> getQuestionValue() {
        return questionValue;
    }

    public void setQuestionValue(Set<Integer> questionValue) {
        this.questionValue = questionValue;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
