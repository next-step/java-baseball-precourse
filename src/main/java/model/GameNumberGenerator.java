package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static model.BaseballNumber.VALID_LENGTH;

public class GameNumberGenerator {

    public static int generate() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits, new Random());

        int num = 0;
        for (int i = 0; i < VALID_LENGTH; i++) {
            num *= 10;
            num += digits.get(i);
        }
        return num;
    }
}
