import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (Character.isLetter(c)) {
                    c = Character.toUpperCase(c);
                }
            } else {
                if (Character.isLetter(c)) {
                    if (s.charAt(i - 1) == ' ') {
                        c = Character.toUpperCase(c);
                    } else {
                        c = Character.toLowerCase(c);
                    }
                }
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}