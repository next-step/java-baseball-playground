## 1단계 : 문자열 계산기

### calculate 메서드
1. 문자열을 입력받아, 주어진 조건에 맞추어 배열로 만듭니다.
2. 연산자만 선택하기 위해, 인덱스 1번부터, 2칸 간격으로 이동한 뒤, 연산자의 바로 오른쪽의 값을 선택합니다. 
3. 이때, 문자열의 정수 변환은 stringToInt 메서드를 별도로 정의한 뒤 이용합니다.
4. 결과값의 초기화는 첫 번째 숫자로 지정한 뒤, 이 결과값과 연산자, 그리고 오른쪽 값을 operate 메서드에 넣어 결과값을 업데이트 합니다.

### operate 메서드
1. 사칙연산자를 받아, 해당되는 연산을 합니다.
2. 입력된 연산자가 사칙연산에 해당되지 않는 경우 예외를 던집니다.

## 2단계 : 숫자 야구

### RandomNumber 클래스
1. getRandomNumber는, 1~9 사이의 서로다른 세 개의 정수로 이루어진 문자열을 반환합니다.

### InputView 클래스
1. 숫자를 입력받는 기능과, 3 스트라이크가 되었을 때 게임을 재시작 / 종료여부를 결정하는 숫자를 입력받는 기능으로 구성되었습니다.

### OutputView 클래스
1. 숫자를 모두 맞췄을 때, 메시지를 추가하는 printGameEndMessage 메서드와, 문자열을 받아 출력해주는 printMessage 메서드로 구성하였습니다.

### BallStrikeStatus 클래스
1. 총 몇 개의 공으로 이루어져 있는지(Baseball 클래스의 TOTAL_NUMBER 상수)를 받아, 모든 숫자를 맞췄는지를 확인하는 isStrikeOut 메서드를 정의하였습니다.
2. 볼과 스트라이크의 수를 업데이트 하는 메서드(updateBallAndStrike / updateCount / resetBallAndStrikeCount) 메서드는 private으로 정의하고, 
getResultMessage 메서드에서 위의 과정을 모두 실행한 뒤 결과 메시지를 반환하도록 설정하였습니다.
   - 처음 정의할 때, 입력을 넣기 애매하여 테스트 코드를 작성하기 힘들었던 문제를 해결했습니다.

### Baseball 클래스
1. 게임의 실행 상태를 나타내는 gameStat 데이터와, 정답을 나타내는 solution 데이터를 필드로 가집니다.
2. playGames 메서느는, InputView를 통해 입력받은 숫자를 기반으로, BallStrikeStatus의 getResultMessage를 호출하여 메시지를 바로 출력합니다.
3. 이후, endOrRestartGameIfStrikeOut을 호출하여, 게임이 종료되면( isGameEnded()의 출력값이 true 이면 ), 게임의 진행 여부를 결정하는 숫자 1,2를 
InputView를 통해 받아 gameStat 필드값을 변경합니다. 