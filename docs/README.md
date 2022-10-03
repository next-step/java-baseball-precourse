숫자 야구 게임

## 요구 사항 정리

- UI
    - 게임 시작 메시지를 콘솔에 보여줌
    - player가 숫자를 입력할 수 있어야 함
- 컴퓨터 역할
    - 1~9 서로 다른 임의의 수 3개 선택
- 플레이어 역할
    - 1~9 서로 다른 임의의 수 3개 입력
    - 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
- 정답 판단
    - 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료
- 힌트
    - 같은 수가 같은 자리에 있으면 스트라이크
    - 다른 자리에 있으면 볼
    - 같은 수가 전혀 없으면 낫싱
- 게임 종료된 후
    - 입력한 숫자가 1인 경우 재시작
    - 입력한 숫자가 2인 경우 종료

## 기능 구현 목록
- RandomNumberGenerator
    - 각 자리는 서로 다른 1~9까지의 수로 이루어져 있다.
    - 3자리 수보다 적거나 많은 자리의 수는 허용하지 않는다.
    - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 이용하여 랜덤 값을 생성한다.


- Judge
    - RandomNumberGenerator에서 생성한 수와 Player가 입력한 수를 판별한다.


- Player
    - player가 입력한 글자의 수를 검사한다.
    - player가 입력한 글자의 중복 값을 검사한다.
    - player가 입력한 글자가 숫자인지 검사한다.


- PlayerInput
    - camp.nextstep.edu.missionutils.Console의 readLine()을 이용해서 사용자가 입력하는 값을 얻는다.


- IllegalArgumentException
    - Player에게 숫자를 입력받을 때 발생할 수 있는 예외
    - 글자수가 초과되었을 경우
    - 중복값이 있을 경우
    - 숫자가 아닌 경우


- GameOption
    - 게임을 계속할 것인지 Player에게 입력을 받는다.
    - 입력 값이 유효한지 검증하는 함수를 만든다.

