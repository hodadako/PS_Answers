import java.math.*;

class Solution {
    public int[] solution(String s) {
        int cur = 0;
        int count = 0;
        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    cur++;
                }
            }
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            count++;
        }
        int[] answer = {count, cur};
        return answer;
    }
}