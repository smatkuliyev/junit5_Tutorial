package org.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class J04_TestingParameterized {

    @Test
        // CIIIISSSSSS ASLA tavsiye edilmez, NOT RECOMMENDED, hangisi hatali gormek zor
    void uzunlukSifirdanByk() {
        assertTrue("yildiz".length() > 0);
        assertTrue("suleyman".length() > 2);
        assertTrue("omer".length() > 3);
        assertTrue("kursat".length() > 4);
    }

    // TEKIL SART...
    /*
    length() method'u ile asagidaki sartlar icin 0'dan buyuk deger return ettigini test ediniz
    Sartlar: "yildiz", "suleyman", "omer", "kursat"  -- bu data'lar testi nasil gecer
     */

    @ParameterizedTest
    // @ValueSource(strings = {"yildiz", "suleyman", "omer","x", "kursat"})
    @ValueSource(strings = {"yildiz", "sulayman", "omer", "kursat"})
    void uzunlukSifirdanBykPrmtrl(String str) {  // @ValueSource -> elemanlari method' parametre olarak donguye girerek run edilir
        //     assertTrue(str.length()>2); // failed
        assertTrue(str.length() > 0);           // passed
    }

    // COKLU SART -> Her parametre elemani KEY VALUE ikili ile test method'unda run edilir
    @ParameterizedTest
    @CsvSource(value = {"yıldız,YILDIZ", "suleyman,SULEYMAN", "omer,OMER", "kursat,KURSAT"})
    // Cvs: comma-separated values
    void testBykHrfCvr(String beklenenBYKhrf, String isim) {
        Assertions.assertEquals(beklenenBYKhrf.toUpperCase(), isim);
    }


    @ParameterizedTest(name = "Expected(BUYUKHARF):{0},actual(cevirilecek):{1}") //CSVFileSource syntax
    //  @CsvFileSource -> belirli bir dosyadan datalari okutarak test icin parametro olarak kullanir
    //  @CsvFileSource ->src/resource klasoru altina konumlanmis dosyaya direk ulasir
    //  numLinesToSkip = a --> a:start line'dan itibaren kalan satirlari run eder
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)    //data.csv dosyasindaki 1. satir haric verileri parametro olarak test method'unda run eder
    void bykHrfCvrFile(String cevirilecek, String bykHrf) {
        Assertions.assertEquals(bykHrf, cevirilecek.toUpperCase());
    //    Assertions.assertEquals(cevirilecek.toUpperCase(), bykHrf);
    }





}
