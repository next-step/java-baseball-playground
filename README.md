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
숫자야구 To Do List
* 숫자를 입력받는다
  1. 3자리 수인지 확인
  2. 1~9사이의 수인지 확인
  3. 중복된 값이 있는지 확인
* 컴퓨터의 랜덤 숫자를 만든다
  1. 3자리 수인지 확인
  2. 1~9사이의 수인지 확인
  3. 중복된 값이 있는지 확인
* 입력한 수가 스트라이크가 몇개인지 확인
* 입련한 수가 볼이 몇개인지 확인

---
수정내용
* 숫자를 입력받는다
  3자리 수인지 확인 -> 3자리 확인 + 숫자인지 확인 두가지 책임이 같이있으므로 분리
  1~9사이의 수인지 확인 -> 앞에서 이미 체크한 내용이므로 제거

수정 후 
* 숫자를 입력받는다
  1. 3자리 확인
  2. 숫자인지 확인
  3. 중복된 값이 있는지 확인

---
수정내용
* 컴퓨터의 랜덤 3자리 숫자를 만든다
  3자리 수인지 확인 -> 입력받아서 처리하는게 아니기 때문에 필요없음
  1~9사이의 수인지 확인 -> 입력받아서 처리하는게 아니기 때문에 필요없음

수정 후
* 컴퓨터의 랜덤 3자리 숫자를 만든다
  1. 중복된 값이 있는지 확인
---

수정내용
* 입력한 수가 스트라이크가 몇개인지 확인
* 입련한 수가 볼이 몇개인지 확인
  몇개인지 확인하는건 여러기능을 복합적으로 확인해야함.

수정 후
* 입력한 수가 스트라이크인지, 볼인지 낫띵인지 확인
  1. 위치와 숫자가 동일하면 스트라이크
  2. 숫자만 존재한다면 볼
  3. 숫자가 존재하지 않다면 낫띵
ex)
computer / user
위치, 숫자 / 위치, 숫자
1, 1     /  1, 1     스트라이크
1, 1     /  2, 1     볼
1, 1     /  2, 4     낫띵

---
(1,1), (2,5), (3,2) / (1,7), (2,6), (3,5) -> 1볼
(1,1), (2,5), (3,2) / (1,1), (2,6), (3,5) -> 1볼 1스트라이크
(1,1), (2,5), (3,2) / (1,1), (2,5), (3,2) -> 3스트라이크

---
* 숫자를 입력받는다
  1. 3자리 확인
  2. 1~9 인지 확인
  3. 중복된 값이 있는지 확인
* 컴퓨터의 랜덤 3자리 숫자를 만든다
  1. 중복된 값이 있는지 확인
---