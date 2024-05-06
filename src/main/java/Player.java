import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    public List<Integer> getNum(){
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner sc= new Scanner(System.in);
        try {
            String inputInt = sc.next();

            if (inputInt.length() != 3){
                throw new IllegalArgumentException();
            }

            if ((inputInt.charAt(0) != inputInt.charAt(1)) && (inputInt.charAt(0) != inputInt.charAt(2)) && (inputInt.charAt(2) != inputInt.charAt(1))){
                return makeListInt(inputInt);
            } else {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> makeListInt(String inputInt){
        List<Integer> inputIntList = new ArrayList<>();

        for(int i = 0; i<3;i++){
            int a = Integer.parseInt(Character.toString(inputInt.charAt(i)));

            if (checkRange(a)) {
                inputIntList.add(a);
            }
        }
        return inputIntList;
    }

    public boolean checkRange(int i){
        if ((i >=0) & (i <9)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
