package Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String str = s.trim().replaceAll("\\s+", " ");

        String [] word_list = str.split(" ");
        List<String> reverseWordList = new ArrayList<>(Arrays.asList(word_list));

        Collections.reverse(reverseWordList);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < reverseWordList.size(); i++) {
            sb.append(reverseWordList.get(i));


            if (i < reverseWordList.size() - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();
        String ans = obj.reverseWords("     The   sky is      Blue        ");
        System.out.println(ans);
    }


}
