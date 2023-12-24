package Strings;

import java.util.*;

public class SortCharByFrequency {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        // Populate the frequency map
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        for (Map.Entry<Character, Integer> entry : entryList) {
            char character = entry.getKey();
            int frequency = entry.getValue();

            // Append the character 'frequency' times
            for (int i = 0; i < frequency; i++) {
                ans.append(character);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        SortCharByFrequency obj = new SortCharByFrequency();

        String result = obj.frequencySort("tree");

        System.out.println(result);
        
    }
}
