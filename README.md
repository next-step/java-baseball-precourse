# java-baseball-precourse

### ⚾️ 기능 요구사항

1. 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
2. 같은 수가 같은 자리에 있으면 `스트라이크`
3. 다른 자리에 있으면 `볼`
4. 같은 수가 전혀 없으면 `낫싱`을 출력한다.

```
상대방(컴퓨터)의 수가 425일 때,
- 123을 제시한 경우: 1스트라이크
- 456을 제시한 경우: 1볼 1스트라이크
- 789를 제시한 경우: 낫싱
```

- 상대방의 역할은 컴퓨터가 하며, 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
- 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터가 생각하고 있는 숫자와 비교한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 에플리케이션은 종료되어야 한다.

**입출력 예제**

```text
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

### ⚾️ 프로그래밍 요구사항

#### ✔️ 입출력 요구사항

**입력**

-[x] 입력은 `java.util.Scanner`를 사용한다.
-[x] 입력은 3개의 **숫자**로 이루어지며 **중복되는 수가 없어야** 한다.
-[x] 각 숫자는 1에서 9까지의 수로 이루어져야 한다.

**출력**

-[x] 출력은 `System.out`을 사용한다.
-[ ] `1볼 1스트라이크`, `낫싱`, `3스트라이크`와 같이 게임 진행 상황을 출력한다.
-[x] 0볼 0스트라이크일 때 `낫싱`을 출력해야 한다.
-[x] 3개의 숫자를 모두 맞히면 `n개의 숫자를 모두 맞히셨습니다! 게임 종료`를 출력한다.
-[x] 게임 재시작을 위해 `1`, 종료를 위해 `2`를 입력받는다.

#### ✔️ 게임 요구사항

- [x] 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
- [x] 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력한다.
- [x] 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- [x] 3개의 숫자를 모두 맞히면 게임이 종료된다.
- [x] 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

#### ✔️ 예외 처리 요구사항

- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 에플리케이션은 종료되어야 한다.
- [x] 숫자가 아닌 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 에플리케이션은 종료되어야 한다.
- [x] 중복되는 수를 입력할 경우 `IllegalArgumentException`을 발생시킨 후 에플리케이션은 종료되어야 한다.
- [x] 입력한 값이 3자리가 아닐 경우 `IllegalArgumentException`을 발생시킨 후 에플리케이션은 종료되어야 한다.
- [x] 게임 재시작을 위해 `1`, 종료를 위해 `2`를 입력받지 않은 경우 `IllegalArgumentException`을 발생시킨 후 에플리케이션은 종료되어야 한다.
