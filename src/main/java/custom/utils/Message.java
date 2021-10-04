package custom.utils;

public class Message {

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
        if(message != null && message.length()>0) {
            return true;
        }
        return false;
    }
}
