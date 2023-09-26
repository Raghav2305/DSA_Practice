package Graphs;

import java.util.*;

class WordPair{
    String word;
    int len;

    public WordPair(String word, int len) {
        this.word = word;
        this.len = len;
    }
}
public class Word_Ladder_1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<WordPair> queue = new LinkedList<>();
        queue.add(new WordPair(beginWord, 1));
        Set<String> set = new HashSet<>();

        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            set.add(wordList.get(i));
        }

        set.remove(beginWord);

        while(!queue.isEmpty()){
            String word = queue.peek().word;
            int sequence_len = queue.peek().len;
            queue.poll();

            if(word.equals(endWord) ) return sequence_len;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z' ; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;

                    String replaceWord = new String(replacedCharArray);
                    if(set.contains(replaceWord)){
                        set.remove(replaceWord);
                        queue.add(new WordPair(replaceWord, sequence_len + 1));
                    }
                }
            }
        }
        return 0;
    }
}
