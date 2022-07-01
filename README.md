<div align="center">
<h1>숫자야구게임</h1>
<b>내 코드는 왜 객체지향적이지 않은가?</b>
</div>
<br>


## **[ 학습 목표 ]**
- 객체지향적인 사고를 연습하자.
- 자바 코드 컨벤션을 지키면서 프로그래밍 하자.
- 테스트 기반으로 리팩터링을 통해 점진적으로 클린코드를 구현하는 경험을 한다.

## **[ 연습할 원칙 ]**
- 한 메서드에 오직 한 단계의 들여쓰기만.
- else 예약어를 쓰지 않는다.

## **[ 기능 목록 ]**
- 1부터 9까지 서로 다른 수로 이루어진 세자리의 수를 맞추는 게임이다.
- [x] 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. NumberGenerator#createNumbers()
- [ ] 게임 플레이어는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다. Referee#compare()
  - [ ] 같은 수가 같은 자리에 있으면 스트라이크 Judgement
  - [ ] 다른 자리에 있으면 볼 Judgement
  - [ ] 같은 수가 전혀 없으면 낫띵 Judgement
- [ ] 3개의 숫자를 모두 맞히면 게임이 종료된다.
- [ ] 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## 
com / player
123   123   3스트라이크
123   134   1볼 1스트라이크 
123   312   3볼
123   456   낫띵
--- 
(1,1) (1,2)  X
(1,3) (1,3)  O
---
(1,2,3) (3,3) O
(1,2,3) (3,4) X