package com.company;

import java.util.Scanner;

public class divisibleBy5Or7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        calc(num);

    }

    public static void calc(int num){
        for (int i = 1; i <=num ; i++) {
            if(i % 5 == 0 || i % 7 == 0){
                System.out.println(i + " ");
            }
        }
    }

}
