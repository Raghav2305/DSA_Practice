package Random_Questions_practice;

public class reverseWordFromSentence {
    public static void main(String[] args) {
        String name = "Raghav Kavimandan";
        String[] arr = name.split(" ");
//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            System.out.print(reverseWord(arr[i]) + " ");
        }
    }

    public static String reverseWord(String word){
        String ans = "";

        for (int i = word.length() -1; i >= 0 ; i--) {
            ans += word.charAt(i);
        }

        return ans;
    }
}
