package Random_Questions_practice;

public class getNextAlphabet {
    public static void main(String[] args) {
        String name = "raghav";
        System.out.println(getNextAlpha(name));
    }

    public static String getNextAlpha(String word){
        String ans = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                ans += Character.toString( ch + 1);
            }else{
                ans += ch;
            }
        }
        return ans;
    }
}
