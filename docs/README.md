기능 요구사항

* 1부터 9까지 서로 다른수로 이루어진 3자리의 수를 맞추는 게임

    1. 야구게임에서 상대방의 역할을 컴퓨터가 하고, 컴퓨터는 1~9까지의 임의의 다른 수를 3개 선택한다.
    - Random 값 추출은 comp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용

    2. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이라는 힌트를 얻고 컴퓨터가 생각하는 3개의 숫자를 맞히면 게임종료,
       게임을 종료한 후 게임을 다시 시작하거나 완전히 종료하는 기능
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 시킨후 프로그램 종료

    3. 사용자가 입력할 수 있고, 결과를 볼 수 있는 UI 구현
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine() 활용