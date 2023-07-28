package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class checkUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String my_str = sc.next();

        System.out.println(calc(my_str));
    }

    private static int calc(String my_str) {
        HashSet<Character> ans = new HashSet<>();

        for (int i = 0; i < my_str.length(); i++) {
//            if(!ans.contains(my_str.charAt(i))){
//
//            }
            ans.add(my_str.charAt(i));
        }

        return ans.size();

}}
