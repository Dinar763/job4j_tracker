package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    public void calcWhenException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                Factorial.calc(-1);
            });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void calcWhenNumberIs5Succesfully() {
        int result = Factorial.calc(5);
        assertEquals(120, result);
    }
}