import java.util.*;

class Solution {
    private String a = "abcdefghijklmnopqrstuvwxyz";
    
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> key = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (!skip.contains(String.valueOf(a.charAt(i)))) {
                key.add(a.charAt(i));
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(key.get((key.indexOf(s.charAt(i)) + index) % key.size()));
        }
        
        System.out.println(key);
        return sb.toString();
    }
}