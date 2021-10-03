package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ReturnStatus {


//    private static Map<Map<BiFunction<Ball, Ball, Double>, Status> statusMap = new HashMap<>();
//
//    static {
//        statusMap.put("+", Status.STRIKE);
//        statusMap.put("-", Status.BALL);
//        statusMap.put("*", Status.NOTHING);
//    }
//
//    public static Status getCalculator(String operator) {
//        return statusMap.get(operator);
//    }

    private static Map<BiFunction<Double, Double, Double> ,String > operators = new HashMap<>();

    static {
        operators.put((num1, num2) -> num1 + num2,"+" );
//        operators.put("/", (num1, num2) -> num1 / num2);
    }

    public static void calculate(String operator, double num1, double num2) {
        System.out.println(operators.get(num1));
//        return operators.get(operator).apply(num1, num2);
    }
}
