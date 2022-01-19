package org.junit;

import java.util.stream.DoubleStream;

public class HesapMakinesi {

    public static double topla(double... sayi) {

        return DoubleStream.of(sayi).sum();
    }

    public static double carp(double... sayi) {

        return DoubleStream.of(sayi).reduce(1,(a,b)->a*b);
    }

}
