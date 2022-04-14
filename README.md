# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록
- [X] ~~컴퓨터 수 생성(1 ~ 9 범위의 숫자 중 랜덤으로 겹치지 않는 3개의 숫자)~~
- [X] 사용자 입력 예외처리
  - [X] 입력 값의 길이 3 검증
  - [X] 입력 값이 1 ~ 9 범위의 숫자 검증
  - [X] 입력 값 중복 검증
  - [X] 숫자만 입력 검증 (문자, 특수문자 등 제외)
- [X] 점수 계산
  - [X] 스트라이크 - 숫자와 입력 위치가 같은 경우
  - [X] 볼 - 숫자는 같지만 입력 위치가 다른 경우
  - [X] 낫싱 - 일치하는 숫자가 없는 경우
- [X] 결과 출력
- [X] 사용자 숫자 입력
  - [X] 잘못된 입력 시 `IllegalArgumentException` 발생 시킨 후 종료
  - [X] 게임 종료 조건 충족 시 다시 시작 여부
  - [X] 게임 종료 조건 미충족 시 계속해서 사용자 입력 받기

## 주의 사항
* 점수 계산 시
    * 라운드 종료 조건에 맞지 않다면 상대방(컴퓨터) 난수 생성 하지 않는다.

## 진행 기록
* `컴퓨터 수 생성(1 ~ 9 범위의 숫자 중 랜덤으로 겹치지 않는 3개의 숫자)` 기능은 제공해준 Utils을 이용하기에 제외함.
* `사용자 입력 예외처리` 기능을 구현하며 최대한 Test Code로 부터 시작하여 기능을 완성함.
* `점수 계산` 최대한 객체지향적으로 스트라이크는 Equals()를 사용하여 객체간 비교를 하도록 알려주신 내용을 기억해 적용함.
* `결과 출력` 을 위해 Map 자료 구조를 사용하였으나.. 객체에게 값을 전달하는 방식으로 개선을 해야하는지 고민임.
* UI를 구현하며 최대한 하나의 함수는 하나의 기능에 집중하도록 구현하고자 했음.
  * 또한 컴퓨터의 입력 값을 받기 위해 123 ~ 987까지의 랜덤 값을 생성했으나, 시간 초과가 있었음
  * 이후 로직은 1~9까지의 3회 랜덤 값을 받아 중복 유효성 검사를 통과할때 까지 랜덤 값 생성을 하도록 하였음.
  ```java
  public List<Integer> inputComputerNumber() {
    int computerNumber;
    do {
        computerNumber = 0;
        computerNumber += Randoms.pickNumberInRange(ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER) * 100;
        computerNumber += Randoms.pickNumberInRange(ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER) * 10;
        computerNumber += Randoms.pickNumberInRange(ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER);
    } while (!ValidationUtils.validateDuplication(computerNumber));
    return numberToList(String.valueOf(computerNumber));
  }
  ```
