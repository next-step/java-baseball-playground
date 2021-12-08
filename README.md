## 숫자 야구 기능 구현 (class/method)
1. 컴퓨터가 3개의 난수를 생성한다. NumberGenerator/makeThreeNumbersByCom
2. 사용자에게서 입력을 받는다. (static)/receiveInputFromUser
3. 두 입력을 비교해 ?볼 ?스트라이크 여부를 판정한다. Referee/compare
   1. 두 입력간 같은 숫자가 총 몇 개인지 센다. Judgement/findSameNumbers
   2. 스트라이크 개수를 센다. 즉, 같은 자리에 같은 수가 몇 개인지 센다. Judgement/getStrikeCnt
4. 게임 진행 결과 및 재시작 구현 GamePlayer/PlayGame