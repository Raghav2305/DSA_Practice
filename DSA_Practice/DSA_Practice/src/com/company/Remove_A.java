package com.company;

import java.util.Scanner;

public class Remove_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        String [] arr = word.split(" ");
        String ans = "";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if(arr[i].charAt(j) != 'A' && arr[i].charAt(j) != 'a'){
                    ans += arr[i].charAt(j);
                }
            }

            ans+= " ";

        }

        System.out.println(ans);
    }



}
