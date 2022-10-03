# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 전 체크리스트
* 터미널에서 `java -version` 실행해 자바 8인지 확인(IDE도 마찬가지)
* Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고, Windows 사용자의 경우 `gradlew.bat clean test` 명령을 실행하여 모든 테스트 통과되는지 확인

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
    * 본인 repository에 소스코드 올려놓고 fork한 repository에 pr 올리기
* [우테캠 Pro 지원 플랫폼](https://apply.techcourse.co.kr/) 통해 과제 최종 제출

## 컨벤션
* [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
* [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
* 기능 단위로 commit

## 세 가지 요구사항
* 기능 요구사항(기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구성)
    1. 1-9까지 서로 다른 수로 이루어진 세 자리 수 만들기
    2. 입력 값 받기
    3. 입력 값 검증 -> IllegalArgumentException 후 애플리케이션 종료
        * 길이
        * 숫자
    4. 판단하기
        1. 스트라이크 
           - 위치, 숫자 모두 동일해야 한다.
        2. 볼
           - 위치는 다르나 숫자는 동일하다.
        3. 낫싱
           - 위치, 숫자 모두 다르다. 
    5. 결과 출력하기
    6. 게임 종료 후 시작하거나 완전히 종료하기
       - 1을 입력 시 새로 시작
       - 2를 입력 시 종료
* 프로그래밍 요구사항
    * JDK 8
    * 시작점은 src/main/java 폴더의 baseball.Application의 `main()`
    * `Random` 및 `Scanner` API 대신 camp.nextstep.edu.missionutils에서 제공하는 `Randoms` 및 `Console` API를 사용
        * Random 값 추출은 Randoms의 `pickNumberInRange()` 활용
        * 사용자 입력 값은 Console의 `readLine()` 활용
    * 구현 완료 시 src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야함
        * (Optional)제공하는 소스 코드 참고해 야구게임을 위한 모든 Test Case 추가해보기
    * [자바 코드 컨벤션](#컨벤션) 지키기
    * indent(들여쓰기) depth가 2를 넘지 않도록 한다. 1까지만 허용
      * while문 안에 if문 있으면 depth 2
      * (힌트) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리
    * stream api 사용하지 않고 구현. 람다는 사용 가능
    * else 예약어 쓰지 않기(당연히 switch/case도)
    * 함수(또는 메서드)의 길이가 10라인 넘어가지 않도록. 한 가지 일만 잘 수행하도록.
    * 도메인 로직에 단위 테스트 구현. 단 UI(System.out, System.in, Scanner) 로직은 제외
        * 핵심 로직을 구현하는 코드와 UI 담당 로직 분리
        * (힌트)MVC 패턴 기반 구현 후 View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집중
    * `학습테스트를 통해 JUnit 학습하기.pdf` 문서 참고
* 과제 진행 요구사항
    * 과제 레포지토리에서 fork/clone
    * `README.md`에 구현할 기능 목록 정리 추가하기
    * `README.md`에 정리한 기능 목록 단위 또는 의미있는 단위로 commit
        * [커밋 메시지 컨벤션](#컨벤션) 참고
    * 과제 제출 방법은 [과제-제출-과정](#과제-제출-과정) 참고
