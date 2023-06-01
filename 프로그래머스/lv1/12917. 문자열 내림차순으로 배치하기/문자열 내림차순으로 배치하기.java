import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<Character> upper = new ArrayList<>();
        ArrayList<Character> lower = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                upper.add(c);
            } else {
                lower.add(c);
            }
        }
        
        Collections.sort(upper, Comparator.reverseOrder());
        Collections.sort(lower, Comparator.reverseOrder());
        StringBuilder sbupper = new StringBuilder();
        for (int i = 0; i < upper.size(); i++) {
            sbupper.append(upper.get(i));
        }
        StringBuilder sblower = new StringBuilder();
        for (int i = 0; i < lower.size(); i++) {
            sblower.append(lower.get(i));
        }
        return sblower.toString() + sbupper.toString();
    }
}