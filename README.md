# java-baseball-precourse

### 게임 소개

- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
- 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 잘못된 입력을 받을 시, IllegalArgumentException 에러를 발생시켜 프로그램을 종료한다.

### 게임 규칙

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 
  수를 맞추면 승리한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 유저는 중복되는 숫자를 입력할 수 없다. 이는 잘못된 입력으로 간주한다.

### 객체

#### Application
- 게임을 진행하는 메인 객체
- class들을 관리하는 객체

#### GenerateTargetNumber
-  게임 플레이어가 맞춰야 하는 난수를 생성하는 객체

#### PlayerInput
- 게임 플레이어의 입력을 받는 객체

#### Compare
- 게임 플레이어의 입력과, 컴퓨터가 생성한 난수를 비교하는 객체
- 만약 유저의 입력이 잘못되었다면, IllegalArgumentException를 발생시키고 종료

#### PlayerInputValidator

- 플레이어가 정답을 맞췄을 때, 게임을 계속 진행할 것인지 나타내는 객체
