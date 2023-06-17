import java.util.*;

class Solution {
    private HashMap<String, Integer> dict = new HashMap<>();
    
    public int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<>();
        int cur = 27;
        int count = 1;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 97);
            dict.put(String.valueOf(Character.toUpperCase(c)), i + 1);
        }
        
        StringBuilder letter = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            for (int k = i; k < msg.length(); k++) {
                    letter.append(msg.charAt(k));
                    if (!dict.containsKey(letter.toString())) {
                        break;
                    }
                }
            
            if (!dict.containsKey(letter.toString())){
                dict.put(letter.toString(), cur);
                letter.deleteCharAt(letter.length() - 1);
            }
            cur++;
            result.add(dict.get(letter.toString()));
            if (letter.length() >= 2) {
                i+= letter.length() - 1;
            }
            letter = new StringBuilder(); 
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
