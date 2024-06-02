
import java.util.HashMap;
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
        this.content=content;
    }
    public void countWord(){
        Map<String,Integer> word=new HashMap<>();
        StringTokenizer tokenizer=new StringTokenizer(content, " ");
        String subString;
        while(tokenizer.hasMoreTokens()){
            subString=tokenizer.nextToken();
            if(word.containsKey(subString)){
                word.put(subString,word.get(subString)+1);
            }else{
                word.put(subString, 1);
            }
        }
        System.out.println(word);
    }
    public void countCharacter(){
        Map<Character,Integer> character=new HashMap<>();
        for (int i = 0; i < content.length(); i++) {
           char c=content.charAt(i);
           if(c!=' '){
               if(character.containsKey(c)){
                   character.put(c, character.get(c)+1);
               }else{
                   character.put(c, 1);
               }
           }   
        }
        System.out.println(character);
    }
}
