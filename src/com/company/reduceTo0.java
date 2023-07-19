package com.company;

public class reduceTo0 {
    public static void main(String[] args) {
        int N = 93;
        System.out.println(calc(N));
    }

    public static int calc(int num){
        if(num == 1){
            return 0;
        }
        if(num == 2){
            return 1;
        }
        if(num == 3){
            return 2;
        }
        else{
            if(num % 2 == 1){
                return 3;
            }
            else{
                return 2;
            }
        }
    }
}
