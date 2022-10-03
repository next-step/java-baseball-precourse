# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

### 구현 기능 목록
- Model 구현
    - Request
        - 유저 게임입력 데이터 모델 (UserAnswerRequest)
        - 유저 게임 진행여부 입력 데이터 모델 (UserPlayRequest)
    - Response
        - 컴퓨터 출력 데이터 모델 (PlayResult)
    - PlayBase
        - baseball 게임 모델 (PlayBase)
- Service 로직 구현
    - BaseballService
        - 유저 입력 데이터와 컴퓨터가 지닌 데이터와 비교후 리턴 (BaseballService)
- UI 구현
    - BaseView
        - 입출력 구현 및 검사 (BaseView)