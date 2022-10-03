package baseball.common;

import java.math.BigDecimal;

public class CharUtils {

    public static BigDecimal convertBigDecimal(char number) {
        return BigDecimal.valueOf(Integer.parseInt(String.valueOf(number)));
    }

}
