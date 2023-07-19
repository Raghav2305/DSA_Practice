package com.company;

import java.util.ArrayList;

public class midOfArray {
    public static void main(String[] args) {
        int[] arr = {11, 23, -3, 3, 5, -3};
        System.out.println(calculate(arr));
    }

    public static int calculate(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<>();

        for (int j : arr) {
            if (j < 0) {
                continue;
            }
            newArr.add(j);
        }

        int len = newArr.size();
        if(len % 2 == 0){
            return newArr.get((len / 2) - 1);
        }
        return newArr.get(len / 2);

    }
}
