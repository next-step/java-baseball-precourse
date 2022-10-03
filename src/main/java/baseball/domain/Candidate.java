package baseball.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Candidate {

    private List<Integer> numberList;

    public static Candidate createCandidateNumber(String inputNumber) {
        Candidate candidate = new Candidate();

        validateInputNumber(inputNumber);
        List<Integer> numberList = setInputNumber(inputNumber);
        candidate.setNumberList(numberList);

        return candidate;
    }

    private static List<Integer> setInputNumber(String inputNumber) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            String substring = inputNumber.substring(i, i + 1);
            numberList.add(Integer.parseInt(substring));
        }
        return numberList;
    }

    private static void validateInputNumber(String inputNumber) {
        validateConvention(inputNumber);
        validateFormat(inputNumber);
        validateDuplication(inputNumber);
    }

    private static void validateConvention(String inputNumber) {
        if (inputNumber == null
                || StringUtils.isBlank(inputNumber)
                || inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private static void validateFormat(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    private static void validateDuplication(String inputNumber) {
        if (isDuplicate(inputNumber)) {
            throw new IllegalArgumentException("입력된 숫자 중 중복된 숫자가 존재합니다.");
        }
    }

    private static boolean isDuplicate(String candidate) {
        Set<Character> set = new HashSet<>();
        int i;
        for (i = 0; i < candidate.length() && !set.contains(candidate.charAt(i)); i++) {
            set.add(candidate.charAt(i));
        }
        return i != candidate.length();
    }

    private void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
