# java-baseball-precourse

## 게임 설명

1부터 9까지 서로 다른 수로 이루어진 상대방의 세 자리의 수를 맞히는 게임

세 자리 수를 제시하면 아래와 같은 규칙으로 힌트가 주어진다. 이를 통해 다시 추리해서 맞혀야 한다.

* 같은 자리에 있다면 스트라이크
* 다른 자리에 있다면 볼
* 존재하지 않으면 낫싱

## 기능

* 임의의 세 자리 수 생성하기

    * 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.

    * 백의 자리 수엔 0이 올 수 없다.
    * 숫자가 중복될 수 없다.
        * 중복 숫자가 존재하면 경우의 수가 너무 많아지기 때문
* 사용자로부터 입력받기
    * 사용자는 반드시 세 자리의 **숫자**만을 입력해야 한다.

    * 잘못된 값을 입력한다면 `IllegalArgumentException`을 발생시키고 애플리케이션이 종료된다.
* 사용자가 제시한 세 자리로 힌트 제시하기
    * 컴퓨터가 임의로 생성한 세 자리 수와 비교해 힌트를 제시한다.

        * 같은 자리에 있다면 스트라이크

        * 다른 자리에 있다면 볼
        * 존재하지 않으면 낫싱
* 컴퓨터가 선택한 세 자리의 수를 정확히 맞히면 게임종료
    * 종료 후에는 게임을 다시 시작할지, 프로그램을 완전히 종료할지 선택할 수 있다.
* **하나의 기능을 구현할 때마다 해당 기능에 대한 테스트 코드 작성하기**
