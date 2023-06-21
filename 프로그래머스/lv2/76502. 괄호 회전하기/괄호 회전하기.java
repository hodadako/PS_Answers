import java.util.*;

class Solution {
    private int answer = 0;
    
    private String makeString(String s, int n) {
        String[] strArr = s.split("");
        LinkedList<String> strList = new LinkedList<>(Arrays.asList(strArr));
        for (int i = 0; i < n; i++) {
            strList.addLast(strList.removeFirst());
        }
        return String.join("", strList);
    }
    
    private void check(String s) {
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        
        if (s.length() == 0) {
            answer++;
        }
    }
    
    public int solution(String s) {
        check(s);
        for (int i = 1; i < s.length(); i++) {
            check(makeString(s, i));
        }
        return answer;
    }
}