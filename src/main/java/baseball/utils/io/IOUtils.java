package baseball.utils.io;

import camp.nextstep.edu.missionutils.Console;

// 입출력 관련 기능은 여기서 처리한다.
public abstract class IOUtils {

    public static String readStringByConsole(String s){
        print(s);
        return Console.readLine();
    }

    public static void print(String s){
        System.out.print(s);
    }

    public static void println(String s){
        System.out.println(s);
    }
}
