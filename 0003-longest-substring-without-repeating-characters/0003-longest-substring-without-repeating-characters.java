import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            map.put(c, i);
            answer = Math.max(answer, i - start + 1);
        }
        return answer;
    }
}