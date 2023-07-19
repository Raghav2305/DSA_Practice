package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class perfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("PLease enter a number: ");
        int inp = sc.nextInt();

        boolean ans = checkPerfect(inp);
        System.out.println(ans);
    }

    public static boolean checkPerfect(int num){
        boolean ans = false;
        int sum = 0;

        for (int i = 1; i <= num ; i++) {
            if(i == num){
                continue;
            }

            if(num % i == 0){
                sum += i;
            }
        }

        if(sum == num){
            ans = true;
        }
        return ans;
    }}
