package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectTest {

    private Dog fido;
    private Dog fidosClone;
    
    @BeforeEach
    void setUp(){
        fido = new Dog("Fido", (float)5.25);
        fidosClone = new Dog("Fido", (float)5.25);
    }

    
    @Test
    void equalsDog(){
        assertThat(fido).isEqualTo(fidosClone);
    }

}
