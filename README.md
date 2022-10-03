# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
1. 사용자 메시지 출력하기
- "숫자를 입력해주세요 : "
- "1볼 1스트라이크", "3스트라이크", "낫싱" etc
- "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
- "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
2. 게임에서 맞혀야 할 1~9까지의 중복되지 않은 세자리 숫자 생성하기
3. 사용자의 입력값 가져오기
4. 2단계에서 생성한 숫자와 3단계에서 입력받은 사용자의 값을 비교하여 스트라이크 개수 세기
5. 2단계에서 생성한 숫자와 3단계에서 입력받은 사용자의 값을 비교하여 볼 개수 세기
6. 2단계에서 생성한 숫자와 3단계에서 입력받은 사용자의 값을 비교하여 '낫싱' 판별하기
7. 2단계에서 생성한 숫자와 3단계에서 입력받은 사용자 값이 동일할 때까지 3~6단계를 반복하기
8. 2단게에서 생성한 숫자와 3단계에서 입력받은 사용자 값이 동일한 경우 반복을 멈추고 게임 리플레이 판별하기
9. 8단계에서 입력받은 게임 리플레이 판별에 따라 기존 1~8단계를 반복하거나 게임을 종료하기

## 예외 처리
1. 게임 플레이를 위해 사용자가 입력한 값의 길이가 3자리가 아니면 IllegalArgumentException 발생
2. 게임 플레이를 위해 사용자가 입력한 값이 1~9 사이의 숫자가 아니면 IllegalArgumentException 발생
3. 게임 플레이를 위해 사용자가 입력한 값에 중복 값이 포함되었으면 IllegalArgumentException 발생
4. 게임 리플레이 여부 확정을 위해 사용자가 입력한 값이 1 또는 2 가 아니면 IllegalArgumentException 발생

## 프로젝트 Class 및 Method
* baseball.Application.jave
Method
1. public static void main(String[] args)

* baseball.domain.Pitches.java
Method
1. private void setPitches(String input)
2. private void validateInput(String input)
3. private void checkInputLength(String input)
4. private void checkInputValue(String input)
5. private void checkDuplicate(String input)
6. public int getPitches(int index)

* baseball.domain.StrikeBalls.java
Method
1. private void setStrikeBalls()
2. private void addIfNotExists(int num)
3. public int getStrikeBall(int index)
4. public boolean contains(int num)

* baseball.service.BaseballGameService.java
Method
1. public void playGame()
2. private Pitches getPitches()
3. private int getStrikeCount()
4. private boolean isStrikeAt(int index)
5. private int getBallCount()
6. private boolean isBallAr(int index)

* baseball.controller.GameMachine.java
Method
1. public void playBaseballGame()

* baseball.view.ConsolePrinter.java
Method
1. public static void printConsoleMsg(Messages msg)
2. public static void printConsoleMsg(String msg)

* baseball.view.ConsoleScanner.java
Method
1. public static String getUserInput()

* baseball.view.MessageFormater.java
Method
1. public static String getGameRsltMsg(int ball, int strike)

## 단위 테스트 항목 선정
* baseball.domain.Pitches.java
1. Pitches를 생성했을 때 정상적으로 값이 세팅되는지를 확인
2. checkInputLength() 의 유효성검사 테스트
3. checkInputValue() 의 유효성검사 테스트
4. checkDuplicate() 의 유효성 검사 테스트

* baseball.domain.StrikeBalls.java
1. StrikeBalls를 생성했을 때 정상적으로 값이 세팅된 상태인지를 확인
2. StrikeBalls에 세팅된 값이 중복이 없는 값인지 확인

* baseball.service.BaseballGameService.java
1. getStrikeCount 가 정상적으로 스트라이크 개수 세는지 확인
2. getBallCount가 정상적으로 볼 개수 세는지 확인

* baseball.controller.GameMachine.java
1. validateUserInput() 의 유효성검사 테스트
