package Strings;

import java.util.Hashtable;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Hashtable<Character, Character> hash = new Hashtable<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(hash.containsKey(c1)){
                if(hash.get(c1) != c2){
                    return false;
                }
            }
            else{
                if(hash.containsValue(c2)){
                    return false;
                }
                hash.put(c1, c2);
            }

        }
        return true;
    }
}
