package org.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class J03_TestingExceptions {
        /*
         assertThrow() metodu --> belirtilen işlemin (executable) belirtilen türde bir Exception oluşturup oluşturmadığını test eder.
        Dolayısıyla 2 parametre alır.

       1. parametre --> expected(beklenen) Exception(istisna) türü,
       2. parametre --> actual(oluşacak)  çalıştırılacak olan işlemdir.

        Eğer işlem belirtilen türde bir exception oluşturursa test başarılı olur.TEST PASSED
        Ama exception oluşmaz ise veya türü yanlış olursa test başarısız olur.TEST FAILED

        TRİCKK : Exception.io türünde parent-child ilişkisi var ise yine test başarılı sayılır.
*/

    @Test
    @DisplayName("NumberFormatException TEST")
    void testException01() {
        String strSayi = "1453a";
        assertThrows(Exception.class, () -> Integer.parseInt(strSayi));
    }

    @Test
    @DisplayName("NullPointerException TEST")
    void testException02() {
        String str = null;
        assertThrows(NullPointerException.class, () -> str.length());      // passed

        //    String str2 = "Gokhan";
        //    assertThrows(NullPointerException.class,()->str2.length());   // failed
    }

    @Test
    @DisplayName("IllegalArgumentException TEST")
    void testException03() {
        assertThrows(IllegalArgumentException.class, () -> yasYazdir(-5));    // passed
        //   assertThrows(IllegalArgumentException.class, () -> yasYazdir(5));       // failed
    }

    void yasYazdir(int yas) {
        if (yas < 0) {
            throw new IllegalArgumentException();

        } else {
            System.out.println(yas);
        }
    }


    @Test
    @DisplayName("ArithmeticException TEST")
    void testException04() {
        assertThrows(ArithmeticException.class, () -> bol(5, 0));          // passed
        //    assertThrows(ArithmeticException.class, () -> bol(5,-1));    // failed

    }

    int bol(int a, int b) {
        return a / b;
    }

}
