package custom.utils;
/**
 * @author Yun JiHun<venaCode93@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Message {

    /**
     * 자바 표준 출력(콘솔 출력)을 하는 java api
     */
    public  Message(){

    }

    public static void printInform(String message) {
        if(isNotEmpty(message)) {
            System.out.print(message);
        }
    }

    public static void printlnInform(String message) {
        if(isNotEmpty(message)) {
            System.out.println(message);
        }
    }

    public static void printError(String message) {
        if(isNotEmpty(message)){
            String errorTag = "[ERROR]";
            System.out.println(errorTag + message);
        }
    }

    private static boolean isNotEmpty(String message){
        return message != null && message.length() > 0;
    }
}
