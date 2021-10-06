# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
### 예외처리
  * [X] 잘못된 값을 입력 했을때 [ERROR] 표시
### 기능구현
  * [X] 1~9까지의 숫자 3자리 입력받는 기능
  * [X] 같은 수 같은자리 일 경우 스트라이크 표시
  * [X] 같은 수 다른자리 일 경우 볼 표시
  * [X] 3개의 숫자 모두 틀린경우 낫싱 표시
  * [X] 게임이 종료 된 뒤 다시시작 or 완전히 종료 하는 기능
### 제약사항
  * [X] 실행하는 시작점은 baseball.Application.main()
  * [X] JDK 8 버전에서 실행가능
  * Random, Scanner API의 경우 nextstep.utils 에서 제공하는 API를 활용
    * [X] Randoms 의 경우 pickNumberInRange() 활용
    * [X] 사용자 입력값은 Console.readLine() 활용
  * [X] 기존 2개의 TestCase 성공
    * 부가적으로 잘못입력했을 때에 대한 TestCase 구현
### 컨벤션
  * [X] indent depth 2가 넘지 않도록 구현
    * 확인 필요
  * [X] stream api 사용안함
  * [X] else 사용안함
  * [X] 메소드 길이가 10라인 넘어가지 않도록 구현
  * [X] https://naver.github.io/hackday-conventions-java/ 컨벤션 확인필요
### 단위테스트
  * [X] 비지니스/UI 로직 분리