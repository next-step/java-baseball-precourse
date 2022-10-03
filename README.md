# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 요구사항 확인
[요구사항 정리](https://github.com/users/Yomni/projects/4)

## 기능 목록
- [x] 게임 시작
  - [x] 1 ~ 9 서로 다른 수로 이루어져 있는지 확인할 수 있는 메소드 정의
  - [x] 멤버 변수가 3자리의 수를 가지고 있는 클래스 정의
- [x] 사용자 입력값에 대한 validation 체크 기능
  - [x] 입력값이 3자리수가 아닌 경우
  - [x] 입력값이 숫자가 아닌 경우
  - [x] 중복된 숫자가 있는 경우
    - ex) 119
- [x] 게임진행
  - [x] 힌트 ENUM 정의
    - [x] 스트라이크 판별
    - [x] 볼 판별
    - [x] 아웃 판별
  - [x] 정답과 입력값 비교하여 결과 Display
- [x] 게임 종료