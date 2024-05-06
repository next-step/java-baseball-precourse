# java-baseball-precourse

- 기능 요구 사항
  - 1~9까지 서로 다른 수로 이루어진 3자리 수를 컴퓨터가 제시한다.
  - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱
  - 컴퓨터가 제시한 3개의 숫자를 플레이어(유저)가 모두 맞히면 게임 종료
    - 그 전까지는 게임이 지속되어야 함.
  - 게임을 종료했을 때, 다시 시작하거나 완전히 종료 가능
  - 플레이어(유저)가 잘못된 값을 입력하면 ```IllegalArgumentException```을 발생시킨 후 애플리케이션 종료
  