# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 커밋 메세지

* feat     : 새로운 기능 추가
* fix      : 버그 수정
* refactor : 프로덕션 코드 리팩토링
* comment  : 필요한 주석 추가 및 변경
* docs     : 문서를 수정한 경우
* test     : 테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X)
* rename   : 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
* remove   : 파일을 삭제하는 작업만 수행한 경우
* chore    : 빌드 테스트 업데이트, 패키지 매니저를 설정하는 경우(프로덕션 코드 변경 X)
* style    : 코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우

##  학습테스트 

* String 클래스 학습테스트 
* Set Collection 학습테스트

## 야구게임 제약사항

* JDK 8  실행 가능 코드
* JDK에서제공하는Random및ScannerAPI대신camp.nextstep.edu.missionutils에서제공하
  는Randoms및ConsoleAPI를사용
* 사용자가잘못된값을입력할경우IllegalArgumentException을발생시킨후애플리케이션은종료
* 코드 컨벤션 google code Style
* indent(인덴트,들여쓰기)depth를2가넘지않도록구현한다.1까지만허용
* 함수(또는메소드)의길이가10라인을넘어가지않도록구현한다.

## 야구게임 기능 명세

* 랜덤 1~9 숫자 생성
* 사용자 3개 수 입력
  * 1~9 숫자 인지 확인
  * 입력 숫자 길이 확인
  * 값 중복 확인
* 입력 값 비교
  * 볼 비교
  * 스트라이크 비교
* 랜덤 수와 입력 값 일치 시 
  * 1 입력 시 처음으로 돌아가 게임 다시 시작!
  * 2 입력 시 프로그램 종료
