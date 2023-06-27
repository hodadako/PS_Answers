class Solution {
    private int[] answer = {0, 0};
    
    private void getLength(int b, int y) {
        for (int i = 1; i <= y; i++) {
            if (y % i == 0) {
                int h = i;
                int w = y / i;
                if (2 * h + 2 * w + 4 == b) {
                    answer[0] = Math.max(h, w) + 2;
                    answer[1] = Math.min(h, w) + 2;
                    break;
                }
            }
        }
    }
    
    public int[] solution(int brown, int yellow) {
        getLength(brown, yellow);
        return answer;
    }
}