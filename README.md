# 프리코스 1주차: 숫자 야구게임

메일을 통해 받은 `프리코스_1주차_숫자야구게임.pdf`을 참고하여 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항을 도출하였다.

## 기능 요구사항

- 숫자 야구게임을 시작하는 기능

- 임의의 난수를 생성하는 기능

    - 0이 포함되지 않은 3자리 수 생성
    - 서로 다른 수로 이루어진 3자리 수 생성

- 사용자로부터 3자리 수를 입력받는 기능

    - 숫자(1~9)가 아닌 다른 문자가 입력될 경우 재입력 요청
    - 3자리 수가 아닌 경우 재입력 요청
    - 3자리 수가 중복된 수로 구성될 경우 재입력 요청

- 임의로 생성된 3자리 수와 입력받은 3자리 수를 비교하는 기능

    - 스트라이크: 같은 수가 같은 자리에 있는 경우의 수를 출력
    - 볼: 같은 수가 다른 자리에 있는 경우의 수를 출력
    - 낫싱: 같은 수가 없는 경우 출력
    - 임의로 생성된 3자리 수를 맞추면 게임종료

- 게임이 종료된 이후, 재시작 여부를 묻는 기능

    - 사용자 입력 값이 1일 경우 재시작
    - 사용자 입력 값이 2일 경우 프로그램 종료

- 사용자가 잘못된 값을 입력할 경우 `[ERROR]`로 시작하는 메시지를 출력하는 기능

## 프로그래밍 요구사항

- 숫자 야구게임을 실행하는 시작점은 `src/main/java` 폴더에 위치한 `baseball.Application`의 main()이다.
- JDK 8 버전에서 실행가능해야 한다.
- JDK에서 기본으로 제공하는 Random, Scanner API 대신 `next.utils` 패키지에서 제공하는 Randoms, Console API를 활용하여 구현한다.
- `src/test/java` 폴더에 위치한 `baseball.ApplicationTest`에 구현되어 있는 2개의 Test Case를 통과해야 한다.
- [**캠퍼스 핵데이 Java 코딩 컨벤션**](https://naver.github.io/hackday-conventions-java/) 을 지키며 프로그래밍한다.
- indent의 depth는 2이상을 허용하지 않는다.
- Stream API는 사용하지 않고 숫자 야구게임을 구현한다. 단, 람다식은 사용할 수 있다.
- `else`, `switch/case` 를 사용하지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 도메인 로직에 해당되는 단위 테스트를 구현한다.

## 과제 진행 요구사항

- [**java-baseball-precourese 저장소**](https://github.com/next-step/java-baseball-precourse) 를 fork / clone 한 후에 과제를 진행한다.
- `README.md` 파일에 숫자 야구게임 기능 요구사항을 정리한다.
- 도출한 기능 요구사항 또는 의미있는 단위로 Commit한다.
- [**AngularJS Git Commit Message Conventions**](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 을 지키며
  Commit 내용을 작성한다.
- [**프리코스 과제 제출 문서**](https://github.com/next-step/nextstep-docs/tree/master/precourse) 를 참고하여 결과물을 제출한다.
