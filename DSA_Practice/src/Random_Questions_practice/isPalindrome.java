package Random_Questions_practice;

public class isPalindrome {
    public static void main(String[] args) {
        String input = "NITIN";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String word){
        String ans = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            ans += word.charAt(i);
        }

        if(ans.equals(word)){
            return true;
        }
        return false;
    }
}
