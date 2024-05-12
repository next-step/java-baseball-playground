package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DescriptionTest {

    Person person;

    @BeforeEach
    void setUp(){
        person = new Person("kim", 34);        
    }

    @Test
    void descriptionAssertFaild(){
        assertThat(person.getAge())
        .as("%s's age should be equal to 100", person.getName())
        .isEqualTo(100);
    }

    

    
}
