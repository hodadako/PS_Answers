import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (map.get(c) > i + 1) {
                        map.put(c, i + 1);
                    }
                } else {
                    map.put(c, i + 1);
                }
            }
        }
        
        int[] answer = new int[targets.length];
        for (int j = 0; j < targets.length; j++) {
            int result = 0;
            for (int i = 0; i < targets[j].length(); i++) {
                char ch = targets[j].charAt(i);
                if (map.containsKey(ch)) {
                    result += map.get(ch);
                } else {
                    result = -1;
                    break;
                }
            }
            
            answer[j] = result;
        }
        return answer;
    }
}