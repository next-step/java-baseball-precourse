# 숫자 야구 ⚾ 
### 🌃 들어가면서

카카오 테크 캠퍼스의 첫번째 미니과제인 숫자 야구<br>
깃의 여러 명령어와 좋은 커밋 단위와 메시지를 학습할 좋은 기회!

(~~그런데 롯데는 왜이렇게 못하냐..?~~)
## 🤗 과제 설명

**게임 설명**<br>

- 맞춰야 하는 수와 자리와 값이 일치하면 스트라이크<br>
- 맞춰야 하는 수와 자리는 다르지만 값은 일치하면 볼<br>
- 맞춰야 하는 수와 자리와 값이 모두 일치하지 않으면 낫싱 (힌트가 된다.)

사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException
`을 발생시킨 후 애플리케이션은 종료되어야 한다
예시 ) 
```
e.g. 상대방(컴퓨터)의 수가 425일 때, 
- 123을 제시한 경우: 1스트라이크 
- 456을 제시한 경우: 1볼 1스트라이크 
- 789를 제시한 경우: 낫싱
```
### ✍️ 시나리오 
```
A는 B가 맞춰야하는 세자리 숫자 123을 정한다.
B는 A에게 숫자를 계속해서 맞추고 A는 그에 맞는 결과를 준다.
예를 들어 (B : 456 -> A : 낫싱), (B : 789 -> A : 낫싱)

⭐만약 B가 : asf라고 할 경우 IllegalArgumentException 예외를 받고 종료된다.
```
### 역할 부여 )
#### 🤖 게임 진행자!
1. 유저의 값을 컴퓨터에게 전달한다.
2. 컴퓨터의 값을 유저에게 전달해준다.


#### 🖥️ 컴퓨터!
1. 유저가 맞출 세자리의 숫자를 정한다.
2. 유저의 입력을 받아서 입력 값에 대한 결과를 준다. ex_ 낫싱, 1볼 2스트라이크 등

#### 🧑 유저(사용자)
1. 게임 규칙에 따라 문제를 맞춘다.

## 객체 지향 관점에서 생각해보기!!
[👉 예전 글 보러가기](https://velog.io/@sseohyun_0v0/series/%EC%9E%90%EB%B0%94%EC%99%80-%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EA%B7%B8%EB%A6%AC%EA%B3%A0-%EC%8A%A4%ED%94%84%EB%A7%81)
### 📌 IoC - 제어의 역전 & DI - 의존성 주입
```
제어의 역전이란? 
이때, DIP를 만족하려면 구체적인 것이 추상화된 것에 의존해야한다.
따라서 B가 A보다 덜 변경되어야하고, 클래스가 아니라 추상화된 것이어야한다.
```
AOP화 함께 고려해서 각 역할의 인터페이스를 두고 (인터페이스는 자주 바뀌지 않는다.), 자주 바뀔 수 있는 게임 진행자가 인터페이스에 의존하도록 둔다.

```
🤔 주입이란?
주입은 외부에서라는 뜻을 내포하고 있는 단어이다.
즉, 외부에서 객체를 장착하는 작업을 말한다.
```
게임 진행자가 객체를 직접 생성하는 것이 아니라, 별도의 주입 객체를 두자. <br>
새로운 구현객체가 생기더라도 코드 변경이 적기 때문에 확장성이 좋아진다.


###  📌 AOP 
```
횡단관심사와 핵심 관심사를 분리하고, 횡단 관심사를 주입할 수 있다. 
👉 ① 시작 직전 ② 종료 직전 ③ 정상 종료 ④ 비정상 종료
```
게임을 진행하면, 서로의 인사와 종료인사가 늘 동일하게 필요하겠지만, 여기서는 이 부분까지는 고려하지 않을 것이다.
프로젝트의 규모가 AOP가 필요할만큼 크지 않다고 느꼈기 때문이다. 


### 📌 PSA - 일관성 있는 서비스 추상화 
```
어떤 것의 종류에 상관없이 같은 방식으로 제어할 수 있도록 PSA를 따라야한다.
```
혹시라도 이후에 B가 바뀔 수도 있으니까 B가 해야할 인터페이스를 두고, 인터페이스로 접근하자.
A 또한 사용자가 아니게 될 수 있으니까 인터페이스를 두고, 인터페이스로 접근하자.

## 객체 지향 설계의 5원칙 : SOLID
>💡 유의할 점 : 객체지향의 4대 특성을 지킬 수 있도록 5대원칙을 잘 고려해보자@@

```
📌 SRP: 단일 책임 원칙 - 🤓 한 클래스는 하나의 책임만 가져야 한다.
```
문제를 내는 인터페이스,구현체는 문제만 낸다.사용자에게 입력을 받지 않는다. <br>

```
📌 OCP: 개방 폐쇄 원칙 - 🤓 자신의 확장에는 열려있고, 주변의 변화에 대해서는 닫혀 있어야한다.
```
게임 진행 구현체가 문제 출제 구현체가 아닌 인터페이스에 의존해, 구현체가 변화더라도 영향을 받지 않는다.
```
📌 LSP: 리스코프 치환 원칙 - 🤔 하위 클래스는 논리적으로 상위 클래스여야한다.
```
여기서는 상속을 쓸 생각이 없기는 하지만,,, 
```
📌 ISP: 인터페이스 분리 원칙 - 🤓 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다.
```
문제를 출제하는 인터페이스와 적절한 값을 주는 인터페이스를 분리하자!


```
📌 DIP: 의존 역전 원칙 - 🤓 자주 변경되는 클래스에 의존하지마라; 자신보다 변하기 쉬운 것에 의존하지마라
```
구현체가 아니라 인터페이스에 의존하도록 하자. 

## 🎯 클래스와 인터페이스 구조 생각해보기

🤔 인터페이스를 구현하는데의 고민
: 문제를 출제하는 인터페이스와 적절한 값을 주는 인터페이스를 분리하는 것이 좋을까??
<br>
적절한 값을 주는 로직은 **이미 고정되어 있다.** 따라서 이 부분이 변경될 일은 적을 것 같다.<br>
하지만 문제 출제방식에는 여러 방식이 존재할 것이다. 따라서 이 부분은 변경될 수 있다.
<br><br>
엄밀히 말한다면, 문제를 출제하는 것과 정답을 판별하는 것은 다른 책임이다.
이 부분을 어떻게 하는 것이 좋을까??...;;;
<br><br>
**인터페이스를 분리하고! 적절한 값을 판단하는 구현체를 내부객체로 가지는 추상 클래를 두어서, 코드 재사용률을 높여야겠다!!**

#### 문제 출제 인터페이스 : TestTaker
1. 1부터 9까지의 문자열을 제공한다.
#### 문제 출제 구현체 : UtilRandomTestTaker
#### 입력값 검수 인터페이스 : ValueChecker
1. 입력값을 받아 스트라이크, 볼, 낫싱 등 적절한 기능을 제공한다. 
#### 입력값 검수 구현체 : StandardvalueChecker
#### 입력값 검수 구현체를 내부 객체로 가지는 추상 클래스 : ProblemManager
#### 추상 클래스를 구현한 구현체 : UtilRandomProblemManagemer


#### 문제를 맞추는 인터페이스 : Participant
1. 입력값을 전달한다.
#### 문제를 맞추는 구현체 : RealParticipant

#### 게임 구성 객체 : ConfigurationObject
1. 각 구성을 채운채 반환한다.

#### 개임 진행 인터페이스 : GameManager
1. 구성을 받은 후, 진행한다.
2. 에러메시지를 적절하게 띄운다.

#### 게임 진행 구현체 : StandarGameManager



## 🎯 구현할 기능 목록

