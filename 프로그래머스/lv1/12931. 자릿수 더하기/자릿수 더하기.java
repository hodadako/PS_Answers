public class Solution {
    public int solution(int n) {
        String s = String.valueOf(n);
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer += Character.getNumericValue(s.charAt(i));
        }

        return answer;
    }
}