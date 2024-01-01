# 문자열 계산기 Todo List

사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현한다.

---

### 프로세스
1. 사용자는 문자열을 입력한다.
2. 입력한 문자열을 공백을 기준으로 분리한다.
3. 분리한 문자열을 숫자와 사칙연산 기호로 구분한다.
4. 사칙연산을 수행한다.
   - 첫번째 숫자를 initial 값으로 설정한다.
   - 숫자와 사칙연산 기호를 순서대로 반복한다.
5. 사칙연산 결과를 출력한다.

---

### 구현할 기능 목록 정리(특정 메서드 단위)
- [X] : 문자열을 입력받는다. - UserInputReader#getInput()
- [X] : 입력받은 문자열을 공백을 기준으로 분리한다. - UserInputReader#splitInput()
- [X] : 분리한 문자열을 숫자와 사칙연산 기호로 구분한다. - UserInputReader#classifyInput()
- [ ] : 사칙연산을 수행한다. - Calculator#calculate()
   - [ ] : 첫번째 숫자를 initial 값으로 설정한다. - setInitialValue()
   - [ ] : 숫자와 사칙연산 기호를 순서대로 반복한다. - 
- [ ] : 사칙연산 결과를 출력한다. - OutputView#printResult()

