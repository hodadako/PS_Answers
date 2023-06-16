import java.util.*;

class Solution {
    private HashMap<String, Integer> result1 = new HashMap<>();
    private HashMap<String, Integer> result2 = new HashMap<>();
    private void makeSet(String str, int k){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++){
            char c = str.charAt(i);
            char d = str.charAt(i + 1);
            if (Character.isLetter(c) && Character.isLetter(d)) {
                sb.append(Character.toLowerCase(c));
                sb.append(Character.toLowerCase(d));
            }
            if(sb.length() != 0){
                if (k == 1) {
                    result1.put(sb.toString(), result1.getOrDefault(sb.toString(), 0) + 1);
                } else {
                    result2.put(sb.toString(), result2.getOrDefault(sb.toString(), 0) + 1);
                }
            }
            sb = new StringBuilder();
        }
    }
    
    public int solution(String str1, String str2) {
        makeSet(str1, 1);
        makeSet(str2, 2);
        // System.out.println(result1); 
        // System.out.println(result2); 

        int answer = 65536;
        if (!result1.isEmpty() || !result2.isEmpty()) {
            double inter = 0, all = 0;
            double temp = 0;
            HashSet<String> keys = new HashSet<>(result1.keySet());
            keys.addAll(result2.keySet());
            for (String s: keys) {
                if (result1.containsKey(s) && result2.containsKey(s)) {
                    inter += Math.min(result1.get(s), result2.get(s));
                    all += Math.max(result1.get(s), result2.get(s));
                } else if (result1.containsKey(s)) {
                    all += result1.get(s);
                } else {
                    all += result2.get(s);
                }
            }
            // System.out.println(inter);
            // System.out.println(all);
            temp = 65536 * inter / all;
            answer = (int) temp;
        }
        return answer;
    }
}