import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class OperatorTest {

    @DisplayName("plus, minus, multiply, divide 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+, 12", "-, 8", "*, 20", "/,5"}, delimiter = ',')
    void operatorTest(String value, String result){

        assertThat(Operator.findOperator(value).operate(10, 2)).isEqualTo(Integer.parseInt(result));

    }
    @Test
    void operatorPlusTest(){
        int result = Operator.PLUS.operate(1,5);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void operatorMinusTest(){
        int result = Operator.MINUS.operate(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void operatorMultiplyTest(){
        int result = Operator.MULTIPLY.operate(10, 2);
        assertThat(result).isEqualTo(20);
    }

    @Test
    void operatorDivideTest(){
        int result = Operator.DIVIDE.operate(100, 10);
        assertThat(result).isEqualTo(10);
    }

}