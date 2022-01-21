package org.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class J05_TestingRepeatedDisable {

    @AfterEach
    void afterMethod(){
        System.out.println("    after calisti ");
        System.out.println("  ************  ");
    }

    @BeforeEach
    void beforeMethod(){
        System.out.println("    before calisti ");
        System.out.println("  ************  ");
    }

    @RepeatedTest(5)
    @DisplayName(" contains 5 kez calisti")
    void testToContain() {

        boolean olusan = "mustafa".contains("hi");//false
        boolean beklenen = false;
        assertEquals(olusan, beklenen, "strin degeri barındırmaz");
        System.out.println("contains run");
    }

    @RepeatedTest(7)
    @DisplayName(" topla 7 kez calisti")
    void topla(){
        assertEquals(5,(2+3));
        System.out.println("topla run");
    }

    @Disabled
    @Test
    void karpuzTest(){
        String str  = "adana";
        assertEquals(5,str.length());

    }



















}
