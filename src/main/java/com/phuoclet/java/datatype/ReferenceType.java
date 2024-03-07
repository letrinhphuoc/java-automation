package com.phuoclet.java.datatype;

import java.util.Arrays;

public class ReferenceType {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        System.out.println("Before :: " + Arrays.toString(arr));
        change(arr);
        System.out.println("After :: " + Arrays.toString(arr));
    }
    private static void change(int[] a){
        a[0]++;
        a[1]++;
        a[2]++;
    }
}
