# java-baseball-precourse

### 숫자 야구 게임 구현하기
1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
위 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 요구사항1
JDK 17 버전에서 실행 가능해야 한다.
로그램 실행의 시작점은 Application의 main이다.
build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
프로그램 종료 시  System.exit()를 호출하지 않는다.
프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.

### 요구사항2
자바 코드 컨벤션을 지키면서 프로그래밍한다.
Google Java Style Guide을 원칙으로 한다.
단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
3항 연산자를 쓰지 않는다.
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### main 로직
main 함수 시작 시 게임이 실행된다.
컴퓨터는 중복이 없는 세자리 난수를 생성한다.
사용자는 임의의 세자리 수를 입력하고 이에 대해 몇 볼, 몇 스트라이크인지 출력한다.
3스트라이크가 되면 해당 난수에 대한 게임 종료, 사용자는 게임을 재시작할지 프로그램을 종료할지 선택할 수 있다.
사용자가 잘못된 값(1123, aabc 등 세자리 수가 아닌 경우)을 입력할 경우 IllegalArgumentException을 발생시키고 종료한다.

### 구현한 기능들
  무작위 3자리수를 생성하는 함수

  각 자리의 숫자가 같은지 확인하는 함수

  각 자리의 숫자가 같은지 확인하는 함수의 부속함수(depth 조절)

  프로그램이 최초 시작인지 재시작인지 확인하는 함수

  볼인지 strike인지 판별하는 함수

  볼인지 strike인지 판별하는 함수의 부속함수(depth 조절)

  몇 볼 몇 스트라이크인지 출력
  
  게임 종료 시 재시작하는지 판별하는 함수

  사용자가 입력한 수가 유효한 수인지 확인하는 함수 (valid_string, oneortwo)

  

  check.java 파일은 잘못 push된 파일입니다.

