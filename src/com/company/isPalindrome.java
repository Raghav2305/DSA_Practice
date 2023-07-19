package com.company;

public class isPalindrome {
    public static void main(String[] args) {
        String check = "nitin";
        String rev = "";

        System.out.println(checkPalindrome(check, rev));
    }

    public static boolean checkPalindrome(String str, String rev){

        boolean ans = false;

        for(int i = str.length() - 1; i>=0; i-- ){
            rev = rev + str.charAt(i);
        }



        if (str.equals(rev)){
            ans = true;
        }

        return ans;
    }


}

