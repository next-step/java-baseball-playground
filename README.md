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
4.구현할 기능 목록
1~9까지의 서로 다른 3자리 맞추는거

~~게임 시작
1. 게임이 시작되면 컴퓨터가 1~9까지의 수 중 중복없는 3자리 수를 랜덤으로 생성
2. "숫자를 입력해 주세요 : " 라는 문구와 함께 사용자로부터 입력 받기
3. 사용자가 유효하지 않은 수를 입력했을시 예외처리
4. 사용자가 입력한 수와 컴퓨터의 수를 비교하여 스트라이크, 볼 계산
5. 2~4번을 반복문으로 돌리고, 만약 정답이라면 게임종료 문구를 출력, 아니라면 계속 진행
6. 게임 종료 후 게임을 다시 시작하냐는 문구 출력, 사용자 입력 받음
7. 사용자 입력에 따라 다시 시작 / 게임 종료 / 
8. 사용자가 유효하지 않은 숫자 입력 시 예외처리 

------------------------

