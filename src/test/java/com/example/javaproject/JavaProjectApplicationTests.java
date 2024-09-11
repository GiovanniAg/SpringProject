package com.example.javaproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JavaProjectApplicationTests {

    @Test
    public void testSum() {
        Calc calculator = new Calc();
        int result = calculator.sum(2, 3);
        assertEquals(5, result);
    }

}
