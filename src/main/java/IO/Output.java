package IO;

public class Output {
    public static void printGameResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
                if (ball > 0) {
                    System.out.print(" ");
                }
            }
            if (ball > 0) {
                System.out.print(ball + "볼");
            }
            System.out.println();
        }
    }
}
