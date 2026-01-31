import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(true) {
            HashSet<Character> set = new HashSet<>();
            boolean empty = false;
            boolean over = false;
            for (String s : strs) {
                if (s.isEmpty()) {
                    empty = true;
                    break;
                }
                if (index < s.length()) {
                    set.add(s.charAt(index));
                } else {
                    over = true;
                    break;
                }
            }
            if (!empty && !over && set.size() == 1) {
                for (char c : set) {
                    sb.append(c);
                }
            } else {
                break;
            }
            index++;
        }
        return sb.toString();
    }
}