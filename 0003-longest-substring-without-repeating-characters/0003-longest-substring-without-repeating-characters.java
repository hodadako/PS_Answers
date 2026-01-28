import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = sb.indexOf(s.charAt(i) + "");
            if (index != -1) {
                answer = Math.max(answer, sb.length());
                sb.delete(0, index + 1);
            }
            sb.append(s.charAt(i));
        }
        answer = Math.max(answer, sb.length());
        return answer;
    }
}