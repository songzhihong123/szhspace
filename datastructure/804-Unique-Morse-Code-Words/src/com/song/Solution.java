package com.song;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        //26个字母对应的摩斯密码
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new TreeSet<>();
        for (String word: words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i)- 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
