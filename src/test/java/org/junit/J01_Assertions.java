package org.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class J01_Assertions {

    @Test
    @DisplayName("ToAssert Testi")
    void testToAssert() {
        int actual = "zekeriya".length();
        int beklenen = 8;

        //  assertEquals(8,actual);             // inline styler : not always used, not recommended
        //  assertEquals(actual,beklenen);      // recommended
        //   assertEquals(beklenen, actual, "beklenen ve actual deger esit degil");  // message will be printed when test failed
        //   assertEquals(5, "islam".length(), "inline is not recommended");     // esit olma durumunu kontrol eder -- pozitif test, expected -> passed

        //   assertNotEquals(9, actual);      // esit olmama durumunu kontrol eder -- negatif test, unexpected -> passed

        //   assertTrue(beklenen == actual);       // assertTrue -> pozitif test: olusturulan sart(boolean) true is passed
        //   assertFalse(7 == actual);               // assertFalse -> negatif test: olusturulan sart(boolean) false is passed


    }

    @Test
    @DisplayName("ConvertUpper Testi")
    void testConvertUpper() {
        String beklenen = "ABDULLAH";
        String olusan = "abdullah".toUpperCase();

        //   assertEquals(beklenen, olusan);     // test esitse passed

        //   beklenen = "ABDULLAh";
        //    assertTrue(beklenen.equals(olusan)); //failed
        //   assertFalse(beklenen.equals(olusan)); // passed

        olusan = null;
        //    assertNull(olusan,"olusan deger null degil");
        //    assertNotNull(olusan); // failed
        olusan = "kursat";
        assertNotNull(olusan);

    }

    @Test
    @DisplayName("ToContains test")
    void testToContains() {
        boolean olusan = "mustafa".contains("hi");
        boolean beklenen = false;

        assertEquals(olusan, beklenen, "String degeri barindirmaz");

    }

    @Test
    @DisplayName("arrays test")
    void testArray() {
        String str = "javacanlara selam olsun ayaginiza das degmesin";
        String olusan[] = str.split(" ");

        String beklenen[] = {"javacanlara", "selam", "olsun", "ayaginiza", "das", "degmesin"};

        assertArrayEquals(beklenen, olusan, "agam array'ler farkli");

        
    }

}
