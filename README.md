# 숫자 야구 게임

## 1. 기능 목록

- Model
  - Number
      - 1~9 범위의 int 변수를 지닌 일급 클래스
      - 잘못된 숫자(1~9)를 입력하면 InvalidNumberRangeException 예외 발생
  - Numbers
      - `각기 다른 세 자리 수`를 지닌 일급 컬렉션
      - isContains: Number가 존재하는지 여부
      - getDigit: Number의 자릿수 반환
      - get: Number 반환
      - 중복된 숫자가 있을 경우 DuplicateNumberException 예외 발생
      - 세 자리수가 아닐 경우 InvalidNumbersSizeException 예외 발생
  - StrikeZone
    - 타자가 공을 칠 수 있는 범위, 즉 플레이어의 입력 값에 대한 결과 이넘 클래스
    - STRIKE, BALL, NOTHING
    - boolean 타입의 두 가지 지역 변수가 존재한다.
      - existsNumber: 같은 숫자가 존재하는지
      - sameDigit: 같은 자릿수인지
    - valueOf(boolean sameNumber, boolean sameDigit) 
  - Hint
    - 플레이어의 StrikeZone 결과를 관리하는 일급 컬렉션(EnumMap<StrikeZone, Integer>)
    - hit(StrikeZone): `StrikeZone`에 대해 count를 증가한다.
  - Player
      - 플레이어의 `Numbers`를 지닌 일급 클래스
      - 입력된 문자열을 통해 `Numbers`를 생성한다.
      - isContainsNumber: 지정된 숫자가 존재하는지 확인한다.
      - getNumberDigit: 지정된 숫자 자릿 수를 반환한다.
  - Computer
      - 컴퓨터의 `Numbers`를 지닌 일급 컬렉션
      - `NumbersGenerator` 구현체를 주입받아 인스턴스를 생성할 수 있다.
      - getHintFromPlayerNumbers: 플레이어의  `Number`를 비교하여, `Hint`을 반환한다.
  - NumbersGenerator
      - `Numbers`를 생성할 Functional 인터페이스
      - `Computer` 테스트 코드에서 지정된 세 자리의 숫자를 받을 수 있도록 구성
- Controller
    - BaseBallGameController
        - 게임 플레이어의 숫자를 판별하여 게임을 진행하는 컨트롤러
- View
    - InputView: 게임 입력 입력 값 클래스
        - `nextstep.utils.Console.readLine()`를 통해 값을 입력 받는다.
    - ResultView: 게임 결과 값 클래스
        - `Hint`의 `StrikeZone`의 count 값을 통해 결과 값을 출력한다.
        - GameConsoleCommand: 숫자 야구 게임의 새로운 게임을 시작할지, 게임을 종료시킬지의 커멘드를 정의한 이넘 클래스
            - RESTART_GAME("1"): 새로운 게임 시작
            - END_GAME("2"): 게임 종료

## 2. 게임 방식

게임 플레이어가 컴퓨터의 숫자를 맞추는 게임이다.

1. :white_check_mark: `컴퓨터`의 숫자는 기본적으로 1부터 9까지 서로 다른 수로 이루어진 세 자리의 수이다.
    1. 세 자리수를 가지고 있다.
    2. 각 숫자는 1~9 범위 내에서 생성된다.
    3. 각 자릿 수의 숫자들은 서로 다른 랜덤한 수를 가지고 있다.
2. :white_check_mark: `게임 플레이어`는 컴퓨터가 생각하고 있는 `세 자리 수`를 입력한다.
    1. 만약 잘못된 값을 입력할 경우 `에러 메시지를 출력하고 게임을 계속 진행`할 수 있어야 한다.
    2. `[ERROR] 잘못된 값을 입력했습니다.`
3. :white_check_mark: 컴퓨터는 입력한 숫자에 대한 `결과`를 출력한다.
    - 같은 수가 같은 자리에 있으면 스트라이크, 다른자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 컴퓨터의 수를 맞추면 승리한다.
    - 컴퓨터의 수가 `425`일때,
        - `123`을 제시한 경우 → 1 스트라이크
        - `456`을 제시한 경우 → 1 스트라이크, 1 볼
        - `789`를 제시한 경우 → 낫싱
4. :white_check_mark: 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
5. :white_check_mark: 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

#### 프로그램 실행 결과

```text
숫자를 입력해주세요 : 123
1스트라이크 1볼
숫자를 입력해주세요 : 222
[ERROR] 잘못된 값을 입력했습니다.
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 끝
게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```
