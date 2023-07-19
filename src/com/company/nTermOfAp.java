package com.company;

import java.util.Scanner;

public class nTermOfAp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int n = sc.nextInt();


        System.out.println(calculate(a1, a2, n));
    }

    public static int calculate(int a1, int a2, int n){
        int k = a2 - a1;
        int startFrom = a2;

        for (int i = 3; i <=n ; i++) {
            startFrom += k;
        }

        return startFrom;
    }
}
