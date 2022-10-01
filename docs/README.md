## 기능 요구 사항
1. 사용자가 숫자를 3개 입력한다. (InputNumbers)
    1. 입력한 문자에 숫자가 아닌 문자가 있으면 예외를 발생한다.
    2. 입력한 숫자가 3글자가 아니면 예외가 발생한다.
    3. 입력한 숫자 각각이 1~9 사이의 값이 아니면 예외가 발생시킨다.
2. 컴퓨터가 3개의 랜덤 숫자를 생성한다. (TargetNumbers)
    1. Number 클래스를 생성하여 원시값을 포장하고, InputNumber, TargetNumber에서 사용한다.
    2. 중복된 값을 생성하지 않기 위해 TargetNumbers에서 랜덤한 숫자를 생성하여 전달한다.
    3. 3개의 숫자를 생성하는 방법을 인터페이스로 추상화하고 전략패턴으로 구현한다.
    4. 3개의 숫자를 생성하고, 전부 다른 숫자인지 확인한다.
3. 입력한 숫자와 컴퓨터가 생성한 숫자를 비교하여 결과값을 반환한다. (NumberMatcher)
    1. NumberMatcher는 인스턴스 변수로 TargetNumbers, InputNumbers를 가진다.
    2. Strike, Ball, Nothing을 가지는 Score enum을 생성한다.
    3. InputNumber에 TargetNumbers를 전달하여 Strike, Ball, Nothing을 판단한다.
    4. 결과값을 List<Score> 형태로 출력한다.
4. 결과값으로 출력된 List<Score>을 가지고 Score별 갯수를 출력한다.
    1. Map<Score, Integer> 형태의 일급컬렉션을 생성하여 전달받은 List<Score>를 Map 형태로 출력한다.
5. 리팩토링이 필요한 코드를 정리한다.
6. Application의 main() 메소드를 구현한다.
    1. InputView, ResultView를 활용하여 콘솔창의 입력, 출력 부분을 담당한다.
    2. 재귀호출을 통해 게임을 지속할 수 있다.
    3. Application Test가 정상 동작할 수 있도록 구현한다.