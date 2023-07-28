package Random_Questions_practice;

public class changeCase {
    public static void main(String[] args) {
        String input = "My namE is RAghav KAVIMandAn";
        change(input);
    }

    public static void change(String sentence){
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if(Character.isUpperCase(ch)){
                System.out.print(Character.toLowerCase(ch) + " ");
            }else{
                System.out.print(Character.toUpperCase(ch) + " ");

            }
        }
    }
}
