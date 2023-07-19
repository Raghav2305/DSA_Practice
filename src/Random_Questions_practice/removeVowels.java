//WORK MORE ON THIS

package Random_Questions_practice;

public class removeVowels {
    public static void main(String[] args) {
        String name = "Raghav Kavimandan";

        System.out.println(remove(name));
    }

    public static String remove(String word){
        String ans = word.replaceAll("[aeiouAEIOU]", "");
        return ans;
    }

// ANOTHER WAY TO DO IT -------------->

//    public static String remove(String word){
//        String ans = "";
//        int c = 1;
//        String[] vowels = {"a", "e", "i", "o", "u"};
//        for (int i = 0; i < word.length(); i++) {
//            if(word.charAt(i) == 'a' || word.charAt(i) == 'e'
//                    || word.charAt(i) == 'i' || word.charAt(i) == 'o'
//                    || word.charAt(i) == 'u'){
//                ans += String.valueOf(c);
////                if(c > 9){
////                    c = 0;
////                }
//                c+=1;
//            }else{
//                ans += word.charAt(i);
//            }
//
//        }
//
//        return ans;
//    }

}
