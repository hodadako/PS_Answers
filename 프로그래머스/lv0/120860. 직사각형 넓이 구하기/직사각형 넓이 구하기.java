class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i < 4; i++) {
            int key1 = dots[0][1];
            if (dots[i][1] == key1) {
                x = Math.abs(dots[0][0] - dots[i][0]);
            }
        }
        
        for (int i = 1; i < 4; i++) {
            int key2 = dots[0][0];
            if (dots[i][0] == key2) {
                y = Math.abs(dots[0][1] - dots[i][1]);
            }
        }
        answer = x * y;
        return answer;
    }
}