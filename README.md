# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

# Features
## RandomNumber
### get()
Policy의 10^IN_GAME_NUMBER_LENGTH-1 ~ 10^IN_GAME_NUMBER_LENGTH 크기의 랜덤 숫자를 String 형식으로 리턴

    Policy.IN_GAME_NUMBER_LENGTH = 3
    String randomNumber = RandomNumber.get() // 10^2 ~ 10^3 범위의 랜덤 숫자(type: String)

## UserInput
### inGame()
Policy의 IN_GAME_NUMBER_LENGTH 만큼 숫자를 입력받아 String 형태로 리턴

    Policy.IN_GAME_NUMBER_LENGTH = 3
    String userInput = UserInput.inGame() // 사용자 입력 3자리 숫자(type: String)

### inMenu()
Policy의 IN_MENU_USER_INPUT_LENGTH 만큼 숫자를 입력받아 String 형태로 리턴

    Policy.IN_GAME_NUMBER_LENGTH = 3
    String userInput = UserInput.inMenu() // 사용자 입력 "1" 또는 "2"

## InputPolicy
### defaultPolicy()
userInput가 policyInputLength와 동일한 길이인지 확인 및 userInput가 숫자인지 확인 후 boolean 리턴
    
    boolean policy = InputPolicy.defaultPolicy("123", 3); // policy == true

### addPolicyInMenu()
userInput이 "1"또는 "2"인지 확인
    
    boolean policy = InputPolicy.addPolicyInMenu("1"); // policy == true
