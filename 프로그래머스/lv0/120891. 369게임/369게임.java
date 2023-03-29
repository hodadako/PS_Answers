import java.util.Arrays;

class Solution {
    public int solution(int order) {
        int answer = 0;
        String orderStr = String.valueOf(order);
        String[] key = {"3", "6", "9"};
        for (int i = 0; i < orderStr.length(); i++) {
            if (Arrays.asList(key).contains(String.valueOf(orderStr.charAt(i)))){
                answer += 1;
            }
        }
        return answer;
    }
}