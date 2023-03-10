class Solution {
    public int solution(int n) {
        int answer = 0;
        int times = n / 7;
        int left = n % 7;
        if (left > 0) {
            answer = times + 1;
        } else {
            answer = times;
        }
        return answer;
    }
}