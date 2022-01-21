package org.junit;

import java.util.Arrays;

public class C03_isArraysEquals {
    /*
     *Task : iki array'i esitliğini kiyaslayan method creat ediniz
     */
    public static boolean arraysCompare(Object[] a, Object[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

}
