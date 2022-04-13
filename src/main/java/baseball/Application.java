package baseball;

import baseball.domain.ComputerRandomNumber;

public class Application {
        public static void main(String[] args) {
                // TODO: 프로그램 구현
        
                // 컴퓨터 랜덤 숫자 클래스 생성
                ComputerRandomNumber num = new ComputerRandomNumber();

                // 랜덤 숫자 생성
                num.RandomNum();
        
                // 생성된 숫자 호출
                num.getRandomNum();

                System.out.println("asdad");



        }
}
