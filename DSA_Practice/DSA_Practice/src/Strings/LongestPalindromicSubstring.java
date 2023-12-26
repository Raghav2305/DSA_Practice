package Strings;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
//        if(s.charAt(0) == s.charAt(s.length() - 1)){
//            return s;
//        }
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();

        int ptr1 = 0;
        int ptr2 = 0;
        int count = 0;

        int i = 0;
        int j = s.length() -1 ;

        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                count+=1;
                if(count == 1){
                    ptr1 = i;
                    ptr2 = j;
                }
                else{
                    count = 0;
                }
                i++;
                j--;
            }
        }

        for(int idx = ptr1; idx <= ptr2; idx++){
            ans.append(s.charAt(idx));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("Working");
        LongestPalindromicSubstring object = new LongestPalindromicSubstring();

        String res = object.longestPalindrome("abb");
        System.out.println("res = " + res);
    }
}
