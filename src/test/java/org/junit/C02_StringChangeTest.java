package org.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class C02_StringChangeTest {
    C02_StringChange strChange;    // object was created
    @BeforeEach
    void setUp() {
        strChange = new C02_StringChange();
        System.out.println("test verisi girisi yapildi");
    }

    @AfterEach
    void tearDown() {
        strChange = null;
        System.out.println("test verisi silindi");
    }

    @ParameterizedTest
    @CsvSource(value = {"BC,ABC", "'',A", "'', AA","B,B", "BCDE,BCDE"})
    void ilkIkiAsil(String kirpilmis, String girdi) {
        assertEquals(kirpilmis, strChange.ilkIkiAsil(girdi));
        System.out.println(" ilk iki A varsa silindi");
    }
}