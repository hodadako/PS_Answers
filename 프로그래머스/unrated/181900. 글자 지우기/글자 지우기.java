import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            ind.add(indices[i]);
        }
        int index = 0;
        while (index < my_string.length()) {
            if (!ind.contains(index)) {
                sb.append(my_string.charAt(index));
            }
            index += 1;
        }
        String answer = sb.toString();
        return answer;
    }
}