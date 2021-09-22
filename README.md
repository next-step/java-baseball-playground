## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```    
## 프로그래밍 요구사항
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.    
   * 기본적으로 Google Java Style Guide을 원칙으로 한다.     
   * 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.           
* indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.       
   * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.       
   * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.       
* else 예약어를 쓰지 않는다.       
   * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.       
   * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.            
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외     
   * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.      
   * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.      
* 3항 연산자를 쓰지 않는다.     
* 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.            
### 항상 쪼개라, 요구사항 -> 기능 -> 기능을 이루는 하위 기능으로 잘게 쪼개라    
```
## 야구게임 요구사항
1. 1 ~ 9 까지의 임의의 수 3개를 중복 없이 뽑는다.     
2. 그 수를 맞추기 위해 3자리 숫자를 입력 한다.      
3. 컴퓨터가 뽑은 숫자와 내가 입력한 숫자를 비교한다.     
4. 스트라이크, 볼, 낫싱을 구현한다.     
   스트라이크 = 자릿수 + 숫자가 맞았을 때       
   볼 = 숫자만 맞았을 때       
   낫싱 = 자릿수 + 숫자 모두 맞지 않았을 때     
5. 숫자와 자릿수가 모두 맞을 때 까지      
   2 ~ 4번을 반복한다.    
6. 숫자를 맞추면 다시할 것인지, 종료할 것인지 선택한다.      
7. 다시 하면 1번 과정 부터 시작, 종료하면 프로그램을 종료한다.     
