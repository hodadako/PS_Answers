import java.util.*;

class Solution {
    public int solution(String t, String p) {
        ArrayList<String> key = new ArrayList<>();
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            key.add(t.substring(i, i + p.length()));
        }
        System.out.println(key);
        int answer = 0;
        for (String s : key) {
            boolean add = true;
            for (int i = 0; i < p.length(); i++) {
                if (Character.getNumericValue(s.charAt(i)) > Character.getNumericValue(p.charAt(i))) {
                    add = false;
                    break;
                } else if (Character.getNumericValue(s.charAt(i)) == Character.getNumericValue(p.charAt(i))) continue;
                else {
                    break;
                }
            }
            if (add) {
                answer++;
            }
        }
        return answer;
    }
}