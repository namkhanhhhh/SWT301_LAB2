
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Counter {
    private String content;

    public Counter(String content) {
        this.content = content;
    }

    public void countAndDisplayNumberOfWords() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content, " ");
        String subStr;
        while (tokenizer.hasMoreTokens()) {
            subStr = tokenizer.nextToken();
            if (wordCountMap.containsKey(subStr)) {
                wordCountMap.put(subStr, wordCountMap.get(subStr) + 1);
            } else {
                wordCountMap.put(subStr, 1);
            }
        }
        System.out.println(wordCountMap);
    }

    public void countAndDisplayNumberOfCharacters() {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (int i = 0; i < content.length(); i++) {
            char character = content.charAt(i);
            if (character != ' ') {
                if (charCountMap.containsKey(character)) {
                    charCountMap.put(character, charCountMap.get(character) + 1);
                } else {
                    charCountMap.put(character, 1);
                }
            }
        }
        System.out.println(charCountMap);
    }
}

