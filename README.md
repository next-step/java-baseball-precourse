# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 구현 기능 목록
* Computer 랜덤숫자 배정
  - 나열된 숫자 중복체크
  - 나열된 숫자 0포함 체크
* Player 숫자 입력 Console 제공
  - Player입력오류 예외처리
* Computer, Player 받은 각각 숫자 배열전환
* (n자리 숫자) Player[0] ~ Player[n-1] ↔ Computer[0] ~ Computer[n-1] 각각 비교 
  - player[a] = Computer[a]         → Return "Strike";
  - player[a] = Computer[b]         → Return "Ball";
  - player[a] != Computer[0 ~ max]  → Return "Nothing";
  - 개별 결과 저장 ex) ++strikeHitCount
* 저장된 결과 종합
* 게임 결과 출력 및 해석
  - No Out (three strikes 미만)      → 게임 계속 진행 → Player 숫자 입력
  - Out (three strikes)              → 게임 다시 시작 or 게임 종료
    - 게임 다시시작 → Player 숫자 입력
    - 게임종료 → Return "Good Bye";

## 게임 요구사항
* 위의 구현 기능 목록 단위로 commit을 진행
* JDK 8 버전에서 실행가능해야 한다.
* 자바 코드 컨벤션을 지키면서 개발한다.
  * (https://naver.github.io/hackday-conventions-java/)
* indend depth 가 2가 넘지 않도록
* else 예약어 사용 불가
* 메소드 로직 길이 10 넘지 않도록
  *  commit log  → (https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고

## TRY
* 근거 있는 코드
* Clean Code
* Test Code 

## COMMENT
* 재밌겠다. ('21.10.01)
* 진행이 안된다... ('21.10.02)
