package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] number1 = "1,2".split(",");
        assertThat(number1).contains("2", "1"); // 순서 상관없이
        assertThat(number1).containsExactly("1", "2"); // 순서까지 일치
        System.out.println("number1 배열 = " + Arrays.toString(number1));

        String[] number2 = "1".split(",");
        assertThat(number2).contains("1");
        assertThat(number2).containsExactly("1");
        System.out.println("number2 배열 = " + Arrays.toString(number2));
    }

    @Test
    void substring() {
        String str = "(1,2)".substring(1, 4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    void charAt() {
        String str = "abc";

        assertThatThrownBy(() -> {
                char charTest = str.charAt(3);
            }).isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 3");

        assertThatThrownBy(() -> {
                char charTest = str.charAt(2);
            }).isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 3");
        }
    }



        class SetTest {
        private Set<Integer> numbers;

        @BeforeEach
        void setUp() {
            numbers = new HashSet<>();
            numbers.add(1);
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
        }

        @Test
        void setSize() {
            System.out.println("set size = " + numbers.size());
        }

        @Test
        void contains() {
            assertThat(numbers.contains(1)).isTrue();
            assertThat(numbers.contains(2)).isTrue();
            assertThat(numbers.contains(3)).isTrue();
            assertThat(numbers.contains(4)).isFalse();
            assertThat(numbers.contains(5)).isFalse();
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void setNumberTest(int number) {
            assertTrue(numbers.contains(number));
        }

            @ParameterizedTest
            @CsvSource({"1", "2", "3"})
            void setNumberTest(String input) {
                int number = Integer.parseInt(input);
                assertTrue(numbers.contains(number));
            }
            }

        class calculatorTest {
            @Test
            void calculatorTest_Addition() {
                String input = "2 + 3 * 4 / 2";
                String[] values = input.split(" ");

                int num1 = Integer.parseInt(values[0]);
                int num2 = Integer.parseInt(values[2]);
                int num3 = Integer.parseInt(values[4]);
                int num4 = Integer.parseInt(values[6]);
                int result1 = 0, result2 = 0, result3 = 0;

                switch (values[1]) {
                    case "+" : result1 = num1 + num2; break;
                    case "-" : result1 = num1 - num2; break;
                    case "*" : result1 = num1 * num2; break;
                    case "/" : result1 = num1 / num2; break;
                    default:
                }
                switch (values[3]) {
                    case "+" : result2 = result1 + num3; break;
                    case "-" : result2 = result1 - num3; break;
                    case "*" : result2 = result1 * num3; break;
                    case "/" : result2 = result1 / num3; break;
                    default:
                }
                switch (values[5]) {
                    case "+" : result3 = result2 + num4;
                    case "-" : result3 = result2 - num4;
                    case "*" : result3 = result2 * num4;
                    case "/" : result3 = result2 / num4;
                    default:
                }
                System.out.println(result3);
                assertThat(result3).isEqualTo(10);
            }


//                @ParameterizedTest
//                @ValueSource(strings = {"1 + 2 * 3 - 4 / 2", "5 - 3 * 2 + 4 / 2"})
//                void calculatorTest(String input) {
//                    String[] values = input.split(" ");
//                    assertThat(values).hasSize(9); // 입력된 값이 공백으로 구분된 3개의 값인지 검증
//                    assertThat(values[0]).matches("\\d+"); // 첫 번째 값이 정수인지 검증
//                    assertThat(values[1]).matches("[+\\-*/]"); // 두 번째 값이 연산자인지 검증
//                    assertThat(values[2]).matches("\\d+"); // 세 번째 값이 정수인지 검증
//                    assertThat(values[3]).matches("[+\\-*/]"); // 네 번째 값이 연산자인지 검증
//                    assertThat(values[4]).matches("\\d+"); // 다섯 번째 값이 정수인지 검증
//                    assertThat(values[5]).matches("[+\\-*/]"); // 여섯 번째 값이 연산자인지 검증
//                    assertThat(values[6]).matches("\\d+"); // 일곱 번째 값이 정수인지 검증
//
//                    int num1 = Integer.parseInt(values[0]);
//                    int num2 = Integer.parseInt(values[2]);
//                    int num3 = Integer.parseInt(values[4]);
//                    int num4 = Integer.parseInt(values[6]);
//                    int num5 = Integer.parseInt(values[8]);
//                    int result1 = 0, result2 = 0, result3 = 0;
//                    switch (values[1]) {
//                        case "+" : result1 = num1 + num2; break;
//                        case "-" : result1 = num1 - num2; break;
//                        case "*" : result1 = num1 * num2; break;
//                        case "/" : result1 = num1 / num2; break;
//                    }
//                    switch (values[3]) {
//                        case "+" : result2 = result1 + num3;
//                        case "-" : result2 = result1 - num3; // 기존 코드에서 수정
//                        case "*" : result2 = result1 * num3; // 기존 코드에서 수정
//                        case "/" : result2 = result1 / num3; // 기존 코드에서 수정
//                    }
//                    switch (values[5]) {
//                        case "+" : result3 = result2 + num4;
//                        case "-" : result3 = result2 - num4; // 기존 코드에서 수정
//                        case "*" : result3 = result2 * num4; // 기존 코드에서 수정
//                        case "/" : result3 = result2 / num4; // 기존 코드에서 수정
//                    }
//                    System.out.println(result3);
//
//                    assertThat(result3).isEqualTo(Integer.parseInt(values[6]));
//                }
            }






