package org.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class C01_HesapMakinesiTest {

    @Test
    @DisplayName("ebik gabik sayilari toplar")      // @DisplayName -> kullanicinin veya yoneticinin bilgilendirilmesi icin,
                                                    //                  test'e etiket creaet eder ve konsola print eder
    void topla() {
        // test case
        assertEquals(3, C01_HesapMakinesi.topla(1, 2));  // passed     // 1 ve 2 topla methodunda 3 yapar diye iddia ediyorum
    //  assertEquals(5, HesapMakinesi.topla(1, 2)); // failed
    }

    @Test
    @DisplayName("ebik gabik sayilari carpar")
    void carp() {

       assertAll(   () ->   assertEquals(2.6, C01_HesapMakinesi.carp(2,1.3)),
                    () ->   assertEquals(4.8, C01_HesapMakinesi.carp(2,2.4)),
                    () ->   assertEquals(-2.7, C01_HesapMakinesi.carp(-3,0.9)),
                    () ->   assertEquals(-18, C01_HesapMakinesi.carp(3,-6))
       );


     //   assertEquals(2.6,HesapMakinesi.carp(2,1.3));
     //   assertEquals(4.8,HesapMakinesi.carp(2,2.4));
     //   assertEquals(-2.7,HesapMakinesi.carp(-3,0.9));
     //   assertEquals(-18,HesapMakinesi.carp(3,-6));
    }
}