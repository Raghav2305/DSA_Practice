package Graphs;

import java.util.*;

public class Word_Ladder_2 {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<>();
        int len = wordList.length;
        for(int i=0; i<len; i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        queue.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            ArrayList<String> vec = queue.peek();
            queue.poll();

            if(vec.size() > level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            if(word.equals(targetWord)){
                if(ans.size() == 0){
                    ans.add(vec);
                }
                else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }

            for(int i=0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char [] replacedArray = word.toCharArray();

                    replacedArray[i] = ch;

                    String replacedWord = new String(replacedArray);
                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        queue.add(temp);

                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }

        }
        return ans;
    }
}
