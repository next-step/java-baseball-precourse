# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 구현 기능 정리
* 컴퓨터는 1 ~ 9 로 이루어진 3자리 랜덤한 숫자를 생성한다.
  * `camp.nextstep.edu.missionutils.Random` 의 pickNumberInRange() 사용
* 사용자(user)로 부터 3자리 숫자를 입력 받는다.
  * `camp.nextstep.edu.missionutils.Console` 의 readLine() 사용 
* 생성된 랜덤숫자와 입력받은 숫자를 비교하고 그 결과를 출력한다.
  * 같은 숫자가 같은 자리에 있으면 `strike`
  * 같은 숫자가 다른 자리에 있으면 `ball`
  * 같은 숫자가 없으면 `nothing`
  * 모두 맞추면 종료한다.
* 종료 이후에 게임을 계속할지 종료할지를 묻고 따른다.
