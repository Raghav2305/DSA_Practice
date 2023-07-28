package com.company;

import java.util.Arrays;

public class isPrime {

    public static void main(String[] args) {
        int number = 111;

        long start = System.nanoTime();

        System.out.println(checkPrime(number));

        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("Execution time: " + execution + " nanoseconds");
        
    }

    public static boolean checkPrime(int num){
        if(num == 1 || num == 0){
            return false;
        }

        for (int i = 2; i <= num/2 ; i++) {
            if (num == i){
                continue;
            }
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

}
