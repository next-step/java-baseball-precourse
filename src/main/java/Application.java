
public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.checkAgain();
    }

    void checkAgain(){
        Print print = new Print();
        NumberScanner scan = new NumberScanner();
        int again;
        while(true) {
            print.gamePrint();
            again = scan.again();
            if (again == 1) continue;
            else if (again == 2) break;
            else throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }
}
