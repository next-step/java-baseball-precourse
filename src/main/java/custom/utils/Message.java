package custom.utils;

public class Message {

    /**
     * 자바 표준 출력(콘솔 출력)을 하는 java api
     */
    public  Message(){

    }

    public static void printInform(String message) {
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
