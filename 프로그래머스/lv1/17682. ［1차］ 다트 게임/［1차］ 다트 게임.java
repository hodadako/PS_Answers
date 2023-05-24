import java.util.*;

class Solution {
    public int solution(String dartResult) {
        ArrayList<Integer> result = new ArrayList<>();
        int answer = 0;
        int index = 0;
        String cur_num = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)){
                cur_num += String.valueOf(c);
            } else if (c == 'S') {
                result.add(Integer.parseInt(cur_num));
                cur_num = "";
                index += 1;
            } else if (c == 'D') {
                int num = Integer.parseInt(cur_num);
                result.add(num * num);
                cur_num = "";
                index += 1;
            } else if (c == 'T') {
                int num = Integer.parseInt(cur_num);
                result.add(num * num * num);
                cur_num = "";
                index += 1;
            } else if (c == '*') {
                result.set(index - 1, 2 * result.get(index - 1));
                if (index >= 2) {
                    result.set(index - 2, 2 * result.get(index - 2));
                }
            } else {
                result.set(index - 1, -1 * result.get(index - 1));
            }
        }
        
        for (int i = 0; i < result.size(); i++) {
            answer += result.get(i);
        }
        return answer;
    }
}