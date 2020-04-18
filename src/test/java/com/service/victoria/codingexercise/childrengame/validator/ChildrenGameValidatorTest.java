package com.service.victoria.codingexercise.childrengame.validator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ChildrenGameValidatorTest {


    @Test
    public void testSuccess() {
        assertThat(ChildrenGameValidator.isValid(4, 9)).isTrue();
    }

    @Test
    public void testWhenNumberZero(){
        assertThat(ChildrenGameValidator.isValid(0, 9)).isFalse();
    }

    @Test
    public void testWhenNumberNegative(){
        assertThat(ChildrenGameValidator.isValid(-1, 9)).isFalse();
    }

    @Test
    public void testWhenPositionZero(){
        assertThat(ChildrenGameValidator.isValid(9, 0)).isFalse();
    }

    @Test
    public void testWhenPositionNegative() {
        assertThat(ChildrenGameValidator.isValid(9, -1)).isFalse();
    }
}
