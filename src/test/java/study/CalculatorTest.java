package study;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 요구사항
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
public class CalculatorTest {

  // 컨텍스트 : 입력순서대로 사칙연산을 실행하는 프로그램
  // 기능 목록
  // 순서대로 계산 여부 테스트
  // 계산 결과 저장 테스트
  // 저장된 결과를 순서대로 계산 테스트

  @DisplayName("순서대로 계산 여부 테스트")
  @Test
  void calculateInOrder(){

  }

  @DisplayName("계산 결과 저장 테스트")
  @Test
  void setResultTest(){

  }

  @DisplayName("저장된 결과를 순서대로 계산 테스트")
  @Test
  void calculateResultsInOrderTest(){

  }





}