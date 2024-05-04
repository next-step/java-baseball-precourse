# java-baseball-precourse

# 숫자 야구 게임 기능 목록

## 기능 요약
이 게임은 사용자가 컴퓨터가 무작위로 생성한 3자리 수를 맞히는 게임이다. 게임의 진행은 다음과 같은 기능들로 이루어진다:

### 1. 컴퓨터가 무작위로 3자리 숫자 생성
- 컴퓨터는 1부터 9까지 중복되지 않는 세 개의 숫자를 무작위로 선택한다.

### 2. 사용자 입력 받기
- 사용자로부터 3자리 수를 입력받는다.
- 입력은 게임 진행 중 반복적으로 이루어진다.

### 3. 입력 검증
- 입력된 숫자가 세 자리인지 확인한다.
- 모든 숫자에 중복이 있는지 검사한다.
- 잘못된 입력이 들어왔을 경우 사용자에게 오류 메시지를 표시하고 종료한다.

### 4. 스트라이크와 볼 계산
- 입력된 숫자와 컴퓨터가 생성한 숫자를 비교하여 스트라이크와 볼의 수를 계산한다.

### 5. 게임 결과 출력
- 현재까지의 스트라이크와 볼의 결과를 사용자에게 알린다.
- 모든 숫자를 맞췄을 경우 게임 종료 메시지를 출력한다.

### 6. 게임 재시작 또는 종료 선택
- 사용자가 게임을 다시 시작할지, 종료할지 선택할 수 있다.
