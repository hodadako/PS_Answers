class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] >= prices[i]) {
                    time += 1;
                } else {
                    time += 1;
                    break;
                }
            }
            answer[i] = time;
        }
        return answer;
    }
}