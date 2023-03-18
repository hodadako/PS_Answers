import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        Map<String, String> map = new HashMap<String, String>();
        String[] array = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h","i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < 26; i++) {
            map.put(morse[i], abc[i]);
        }
        
        for (int i = 0; i < array.length; i++) {
            answer += map.get(array[i]);
        }
        return answer;
    }
}