import java.util.*;

class Solution {
    private ArrayList<String> result = new ArrayList<>();
    
    
    public int solution(String s) {
        int head = 0, tail = 0;
        char cur = '1';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (cur == '1')  {
                cur = s.charAt(i);
            }
            if (cur == s.charAt(i)) {
                head++;
            } else {
                tail++;
            }
            sb.append(s.charAt(i));
            
            if (head == tail) {
                result.add(sb.toString());
                sb = new StringBuilder();
                head = 0;
                tail = 0;
                cur = '1'; 
            }
        }
        if (sb.length() != 0) {
            result.add(sb.toString());
        }
        
        System.out.println(result);
        return result.size();
    }
}