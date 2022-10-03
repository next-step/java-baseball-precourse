package baseball.controller;

import baseball.view.HitterInput;

import java.util.LinkedHashSet;
import java.util.Set;

public class Hitter implements Rule {
    private Set<Integer> answerValue;
    private String inputValue;

    public Hitter() {
        setAnswerValue(new LinkedHashSet<>());
    }

    public void swing() {
        setInputValue(new HitterInput().inputValue());
        setAnswerValue();
    }

    private void setAnswerValue() {
        getAnswerValue().clear();

        for (char character : getInputValue().toCharArray()) {
            getAnswerValue().add(Integer.parseInt(String.valueOf(character)));
        }
    }

    public Set<Integer> getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(Set<Integer> answerValue) {
        this.answerValue = answerValue;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
