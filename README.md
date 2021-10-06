
# 기능 목록 정리

- 숫자야구를 할 숫자가 필요하다 (Baseball)
  - 총 3개의 볼이 필요하다 (Baseball : Ball)
  - 3개의 볼은 중복을 허용하지 않는다 (Baseball)
  - 볼은 한 개당 위치와 값이 존재한다 (Ball : BallNumber, BallPosition)
  - 값은 1부터 9까지만 가능하다 (BallNumber)
  - 위치는 0, 1, 2만 가능하다 (BallPosition)
- 하나의 숫자를 비교하여 3가지의 결과를 도출한다 (BallResult)
  - 같은 수, 같은 자리 - 스트라이크 (Ball)
  - 같은 수, 다른 자리 - 볼 (Ball)
  - 같은 수 전혀 없음  - 낫싱 (Ball)
- 컴퓨터 
  - 게임을 할 숫자를 랜덤으로 갖고 있다 (computer)
- 플레이어 
  - 게임을 할 숫자를 입력받아 갖고 있다 (player)
- 게임 진행 
  - 시작시 컴퓨터와 플레이어를 호출한다 (baseballController)
  - 3자리 모두 맞출 때 까지 반복한다. (baseballController)
  - 게임을 종료한 후 다시 시작하거나 완전히 종료한다. (baseballController)

# 도메인 분석
- 예상되는 3자리 숫자를 제시하여 나온 결과를 바탕으로 3자리 숫자를 맞춰야함
- 모두 한자리씩 비교
- 모든 숫자는 자리와, 값이 존재
- strike 이면서 동시에 ball일 수 없음 (1가지 조건만 가능)

# 예외처리 (추가 요건)
# 코딩 컨벤션 
# 프로그래밍 요구사항 


