package org.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class C03_isArraysEqualsTest {


    @ParameterizedTest
    @MethodSource("arraySupplier")
        // test icin parametre kaynagi
    void arraysCompare(boolean sonuc, Object[] x, Object[] y) {
        assertEquals(sonuc, C03_isArraysEquals.arraysCompare(x,y));

    }

    static Stream<Arguments> arraySupplier() {   // Trick: return tek parametro icin dondurulurken, Stream<Arguments> komutu ile 3 parametreli
        // return eder
        // arraySupplier() -> method'u Stream class'ina argument parametreleri return eder

        Integer a1[] = {1, 2, 3, 4};
        Integer a2[] = {4, 3, 2, 1};

        String s1[] = {"h", "a", "y"};
        String s2[] = {"h", "y", "a"};

        Double d1[] = {1.2, 2.3, 5.6};
        Double d2[] = {5.6,2.3, 1.2};

        Float f1[] = {1f, 2f, 67f, 35f};
        Float f2[] = {11f, 20f, 67f, 35f};

        return Stream.of(Arguments.of(true, a1, a2),
                Arguments.of(true, s1, s2),
                Arguments.of(true, d1, d2),
                Arguments.of(false, f1, f2));

    }
}