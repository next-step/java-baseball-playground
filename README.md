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

---

[기능 목록]
```
1. 서로 중복되지않는 난수 3개 생성 - RandomGenerator#createRandomNums
2. 사용자 숫자 입력 받기 - InputView#getNumberInput
3. 정답과 비교 - ResultChecker#compareNums
    3-1. 위치 O, 숫자포함 O -> 스트라이크 - ResultClassifier#isStrike
    3-2. 위치 X, 숫자포함 O -> 볼 - ResultClassifier#isBall
    3-3. 위치 X, 숫자포함 X -> 낫싱 - ResultClassifier#isNothing
4. 결과 출력 - ResultPrinter#printResult
5. 3 strike인지 확인 -> 종료 or 2번부터 다시 loop - ResultChecker#isGameEnd
6. 재시작 판단 
    5-1. 사용자 입력 받기 - InputView#getGameRestartInput
    5-2. "1" -> 게임 재시작
    5-3. "2" -> 종료
```
