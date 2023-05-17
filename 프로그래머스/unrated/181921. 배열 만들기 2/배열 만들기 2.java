import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            String cur = String.valueOf(i);
            boolean flag = true;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) != '5' && cur.charAt(j) != '0') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(Integer.parseInt(cur));
            }
        }
        
        if (result.isEmpty()) {
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
    }
}