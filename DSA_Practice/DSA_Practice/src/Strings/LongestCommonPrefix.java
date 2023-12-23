package Strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);

            for (String str : strs) {
                if (i >= str.length()  || str.charAt(i) != temp) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
