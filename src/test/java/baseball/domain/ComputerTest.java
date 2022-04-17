package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ComputerTest {
    final private Computer testComputer = Computer.createComputer();
    @Test
    @DisplayName(value = "컴퓨터 랜덤 번호 생성 범위 밸리데이션 테스트")
    public void isNumberInRangeTest(){
        ArrayList<String> strNumberList = testComputer.generateRandomNumberList();
        int testNumber = 0;
        int strNumberListIdx = 0;
        for(String strNumber: strNumberList){
            int number = Integer.parseInt(strNumber);
            testNumber+= number*Math.pow(10,strNumberListIdx);
            strNumberListIdx+=1;
        }
        assertThat(testNumber).isBetween(111,999);
    }


    @Test
    @DisplayName(value = "랜덤 번호 생성 중복 테스트")
    public void isDuplicatedTest(){
        ArrayList<String> strNumberList = testComputer.generateRandomNumberList();
        int strNumberCountList[] = new int[10];
        for(String strNumber : strNumberList){
            strNumberCountList[Integer.parseInt(strNumber)]+=1;
        }
        for(Integer numberCount : strNumberCountList){
            assertThat(numberCount).isLessThanOrEqualTo(1);
        }
    }


    @Test
    @DisplayName(value = "랜덤 생성 번호 갯수 테스트")
    public void isLengthThreeTest(){
        ArrayList<String> generatedNumberList = testComputer.generateRandomNumberList();
        assertThat(generatedNumberList.size()).isEqualTo(3);
    }
}
