import java.util.*;

class Solution {
    boolean solution(String s) {
        LinkedList<Character> q = new LinkedList<>(); 
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            if (q.isEmpty()) {
                q.add(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (q.peekLast() == '(') {
                        q.removeLast();
                    } else {
                        q.add(s.charAt(i));
                    }
                } else {
                    q.add(s.charAt(i));
                }
            }
        }
        
        if (!q.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}