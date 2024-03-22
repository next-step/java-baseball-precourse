import java.util.*;

public class BaseballGame {
    public static void main(String[] args) {
        // 1. 랜덤 세자리 수 생성
        Integer[] numbers = {1,2,3,4,5,6,7,8,9};
        List<Integer> numberLists = Arrays.asList(numbers);
        Collections.shuffle(numberLists);
        int[] answer = {numberLists.get(0), + numberLists.get(1), numberLists.get(2)};

        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i=0; i<answer.length; i++) {
            numberMap.put(answer[i], i);
        }

        while (true) {
            // 2. 사용자 입력
            Scanner sc = new Scanner(System.in);
            System.out.println("숫자를 입력해주세요 : ");

            String number = sc.next();

            // 3. 게임 종료 여부 판단
            if (Integer.parseInt(number) == answer[0] * 100 + answer[1] * 10 + answer[2]) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }

            // 4. 일치하는 숫자 판단 <스트라이크, 볼>
            int[] count = new int[2];
            for (int i=0; i<3; i++) {
                int inputNum = Character.getNumericValue(number.charAt(i));

                // 숫자가 포함되어 있다.
                if (numberMap.containsKey(inputNum)) {
                    // 자리가 동일하다.
                    if (numberMap.get(inputNum) == i) {
                        count[0] += 1;
                        continue;
                    }

                    count[1] += 1;
                }
            }

            // 5. 힌트 출력
            if (count[0] == 0 && count[1] == 0) {
                System.out.println("낫싱");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            if (count[0] > 0) sb.append(count[0]).append(" 스트라이크");
            if (count[1] > 0) sb.append(count[1]).append(" 볼");

            System.out.println(sb);
        }
    }
}
