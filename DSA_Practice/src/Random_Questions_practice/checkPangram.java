package Random_Questions_practice;

public class checkPangram {
    public static void main(String[] args) {
        String input = "Abcdefghijklmnopqrstuvwxyz12";
        System.out.println(Pangram(input));
    }

    public static boolean Pangram(String sentence){

        sentence = sentence.toLowerCase();
        boolean isPangram = true;

        for (char ch = 'a'; ch <= 'z' ; ch++) {
            if(!sentence.contains(String.valueOf(ch))){
                isPangram = false;
                break;
            }
        }
        return isPangram;
    }
}
