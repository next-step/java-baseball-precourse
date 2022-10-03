package baseball.entity;

import camp.nextstep.edu.missionutils.Console;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Player {
    private String playerNumbers;

    public String inputThreeNumbers() {

        System.out.print("숫자를 입력해주세요 : ");

        String inputType = Console.readLine();
        if (inputType.length() > 3) {
            throw new IllegalArgumentException("3자리의 1~9사이 숫자를 입력해주세요.");
        }

        this.playerNumbers = inputType;

        return inputType;

    }

}