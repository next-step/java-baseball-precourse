package custom.utils;

public class Message {

    public  Message(){

    }

    public static void printInform(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        String errorTag = "[ERROR]";
        System.out.println(errorTag+message);
    }
}
