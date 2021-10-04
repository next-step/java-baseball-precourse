# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 구현 기능 목록

---

- 게임 시작 
- 게임 종료
- 정답 생성
- 유효성 검사
- 입력 시도 
- 정답 확인
- 힌트 제공
- 승리
- 입력 시도 횟수 저장

## 구현 객체 및 주요 메소드

--- 
1. Game
    + **한번의 게임을 의미** 
    + start() -> 새로운 게임 시작
    + tryTyping() -> 사용자의 입력따라 결과 반환 
    + checkAnswer() -> 입력받은 값과 정답을 비교하여 정답 여부 판단

2. TryResult
   + **한번 입력된 게임의 결과**
   + getAnswer() -> 중복이 없는 정답 생성
   + addResultEnum() -> 입력 시도의 결과를 저장
   + toString() -> 입력 시도의 결과를 메세지로 도출

3. Computer
   + **전체적인 게임과 진행에 관련된 메세지 출력**
   + play() -> 게임의 시작과, 종료를 담당
   + startGame() -> 새로운 게임 시작
   + validAndTry() -> 게임 결과를 확인 한 후 계속 입력 진행
   + exitProgram() -> 결과를 출력하고 프로그램을 종료

4. Validator
   + **입력 값의 유효성을 검사, 유효성이 맞지 않을시 에러 생성**
   + isLengthCheck() -> 공백 및 길이 검사
   + isMatchPattern() -> 정규식 검사
   + isDuplicated() -> 중복 검사

## 예외

---

+ 중복 값 입력
+ 숫자가 아닌 문자 입력
+ 3개 이상 문자열 입력

