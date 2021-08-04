package BaseBall;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {


    @Test
    void name() {
        Referee referee =new Referee();
        Printer printer=new Printer();
        String str = printer.print(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2));
        Assertions.assertThat(str).isEqualTo("3볼");
    }
}