class Solution {
    
    public int getCount(int n) {
        int count = 1;
        for (int i = 2; i <= n; i++)  {
            if (n % i == 0) {
                count += 1;
            }
        }
        return count;
    }
    
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (getCount(i) >= 3) {
                answer += 1;
            }
        }
        return answer;
    }
}