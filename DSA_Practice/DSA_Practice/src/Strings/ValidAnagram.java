package Strings;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey((s.charAt(i)))) {
               map.put((s.charAt(i)), 0);
            }
            map.put((s.charAt(i)), map.get((s.charAt(i))) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);

            if(!map.containsKey(currentChar) || map.get(currentChar) == 0 ) {
                return false;
            }

            map.put(currentChar, map.get(currentChar) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        Boolean ans = obj.isAnagram("cat", "bar");
        System.out.println(ans);
    }
}
