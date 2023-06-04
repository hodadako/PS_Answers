class Solution {
    public int solution(int n, int m, int[] section) {
        int cur = 0;
        int answer = 0;
        for (int i = 0; i < section.length; i++) {
            if (cur < section[i]) {
                cur = section[i] + m - 1;
                answer += 1;
            }
        }
        return answer;
    }
}