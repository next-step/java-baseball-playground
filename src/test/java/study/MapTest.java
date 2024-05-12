package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapTest {
    Map<Integer, String> map;

    @BeforeEach
    void setUp(){
        map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
    } 

    @Test
    void containsEntry(){
        assertThat(map).contains(entry(1, "a"));
    }

    @Test
    void containsKey(){
        assertThat(map).containsKey(2);
    }

    @Test
    void notContainsEntry(){
        assertThat(map).doesNotContain(entry(1, "c"));
    }

    @Test
    void notContainsKey(){
        assertThat(map).doesNotContainKey(2);
    }
    
}
