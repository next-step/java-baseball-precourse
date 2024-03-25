import java.util.List;

public class Computer {
    private static List<Integer> answer;
    public static boolean isEnded;

    public Computer(List<Integer> numbers){
        this.answer=numbers;
        this.isEnded=false;
    }

    public int[] checkAnswer(List<Integer> numbers){
        int ball = 0;
        int strike = 0;
        for(int i=0; i<3; i++){
            if(hasStrike(i,numbers)){
                strike++;
            }
            if(!hasStrike(i,numbers) && hasBall(i,numbers)){
                ball++;
            }
        }
        if(strike==3){
            isEnded=true;
        }
        return new int[]{strike, ball};
    }

    private boolean hasStrike(int i, List<Integer> numbers){
        return answer.get(i).equals(numbers.get(i));
    }

    private boolean hasBall(int i, List<Integer> numbers){
        return answer.contains(numbers.get(i));
    }

}
