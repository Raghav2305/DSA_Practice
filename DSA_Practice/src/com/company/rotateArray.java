package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class rotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int rotateWith = scanner.nextInt();

        int[] ans = rotateArrayRight(arr, rotateWith, arr.length);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] rotateArrayLeft(int[] arr, int rotate, int length) {

        for (int i = 0; i < rotate; i++) {
            int temp = arr[0];

            for (int j = 0; j < length - 1; j++) {
                arr[j] = arr[j+1];
            }

            arr[length - 1] = temp;
        }


        return arr;

    }

    private static int[] rotateArrayRight(int[] arr, int rotate, int length) {

        for (int i = 0; i < rotate; i++) {
            int temp = arr[length - 1];

            for (int j = length -1; j > 0; j--) {
                arr[j] = arr[j-1];
            }

            arr[0] = temp;
        }


        return arr;

    }

}
