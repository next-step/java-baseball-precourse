# java-baseball-precourse

- [기능 요구 사항 정리](#기능-요구-사항-정리)

- [프로그래밍 요구 사항 정리](#프로그래밍-요구-사항-정리)

- [구현 기능 목록](#구현-기능-목록)

- [과제 진행 소감](#과제-진행-소감)

# 기능 요구 사항 정리

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의
수를 맞추면 승리한다

- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는
3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다

- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다

- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다

- 사용자가 잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생시킨 후 애플리케이션은 종료되어야 한다

### 실행 결과
```
숫자를 입력해 주세요 : 123
1볼 1스트라이크
숫자를 입력해 주세요 : 145
1볼
숫자를 입력해 주세요 : 671
2볼
숫자를 입력해 주세요 : 216
1스트라이크
숫자를 입력해 주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해 주세요 : 123
1볼
…
```
# 프로그래밍 요구 사항 정리

- JDK 17 버전에서 실행 가능해야 한다

- 프로그램 실행의 시작점은 **Application** 의 **main()** 이다

- **build.gradle** 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다

- 프로그램 종료 시 **System.exit()** 를 호출하지 않는다

- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다

- 자바 코드 컨벤션을 지키면서 프로그래밍한다

    - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다

    - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다

    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다

    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다

- 3항 연산자를 쓰지 않는다

- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라

- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다

- 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다

    - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

    - [AssertJ User Guide](https://assertj.github.io/doc/)

    - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)

    - [Guide to JUnit 5 Parameterized Test](https://www.baeldung.com/parameterized-tests-junit-5)

# 구현 기능 목록

1. 1부터 9까지의 숫자에서 3개를 선택하여 3자리 수를 선정

2. 숫자 입력 문구를 출력
    
3. 3자리 수를 입력 받기

4. 입력값이 서로 다른 수로 이루어진 3자리의 수인지 검사

5. 입력값 형식이 올바르지 않은 경우 IllegalArgumentException 발생하여 프로그램 종료

6. 입력값과 컴퓨터가 선택한 숫자를 비교하여 볼카운트 계산
    * 같은 자리에서 숫자가 같은 경우 스트라이크 
    * 다른 자리에서 숫자가 같은 경우 볼
    * 스트라이크와 볼 모두 없는 경우 낫싱

7. 볼카운트 계산 결과를 통해 힌트 문구를 출력

8. 게임의 승패 유무를 판단
    * 3스트라이크 => 게임 종료
    * 3스트라이크 X => 숫자 입력 단계로 이동

9. 게임 종료 시 게임 재시작 및 프로그램 종료 선택 문구를 출력
    
10. 게임 재시작할지, 프로그램을 종료할지 선택하도록 입력 받기 
    * 1 입력 => 게임 재시작
    * 2 입력 => 프로그램 종료

# 과제 진행 소감
첫 미니과제를 완성하기까지 리팩토링을 많이 해보면서 정말 의미 있는 시간을 보냈습니다.

게임에 필요한 기능들을 다 구현해놓더라도, 하나의 기능을 분리해서 더욱 읽기 편하게 코드를 수정할 수 있는지 확인하거나

특정 객체에 기능이 쏠려 있으면 새 객체를 만들어서 해당 객체에 기능을 나누는 등 리팩토링하는 데 시간을 많이 투자했습니다.

그러다보니 기능 단위로 커밋을 하겠다는 본래 목적과 달리 점점 리팩토링 관련 커밋이 늘어났고 어느덧 100개는 훌쩍 넘겼습니다.

엄청나게 불어난 커밋 양에 리팩토링하는 동안 커밋은 좀 줄여야겠다 생각이 들었습니다.

하지만 리팩토링을 거듭해보고 나니 코드를 보는 능력을 기를 수 있었습니다.

첫 시작에 기대 이상으로 배운 게 많으니 앞으로의 과제는 어떠할지 기대됩니다!
