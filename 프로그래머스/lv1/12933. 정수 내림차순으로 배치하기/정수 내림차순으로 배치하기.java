import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp.add(String.valueOf(s.charAt(i)));
        }
        
        Collections.sort(tmp, Comparator.reverseOrder());
        
        long answer = Long.parseLong(String.join("", tmp));
        return answer;
    }
}