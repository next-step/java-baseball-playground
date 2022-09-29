package study.baseballgame;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseBallGameTest {

    private BaseballGame bs;

    @BeforeEach
    void makeBaseball() throws IOException{
        bs = BaseballGame.start();
    }

    @Test
    @DisplayName("난수 생성 ")
    void methodTest1() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method makeNanSuMethod = bs.getClass().getDeclaredMethod("makeNanSu");
        makeNanSuMethod.setAccessible(true);

        String ret = (String)makeNanSuMethod.invoke(bs);

        org.assertj.core.api.Assertions.assertThat(ret.length()).isEqualTo(3);
    }



    @Test
    @DisplayName("서로다른 세자리 수")
    void methodTestVaild() throws IOException {
        assertThat(bs.valid("123")).isTrue();
    }

    @Test
    @DisplayName("1-9까지 서로다른 숫자로 이루어진 3자리 숫자 ")
    void methodTest3() throws IOException{
        assertThrows(IllegalArgumentException.class,() -> bs.valid("1222"));
    }

    @Test
    @DisplayName("난수 생성 여부 확인")
    void 객체를_만들때_난수가_생성되는지_확인() throws NoSuchFieldException {
        Field randomNumber = bs.getClass().getDeclaredField("randomNumber");
        randomNumber.setAccessible(true);
    }

    @Test
    @DisplayName("1-9까지 서로다른 숫자로 이루어진 3자리 숫자 ")
    void methodTest5(){

    }

}
