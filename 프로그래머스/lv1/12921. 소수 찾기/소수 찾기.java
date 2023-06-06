class Solution {
    public boolean isPrime(int n) {
        boolean result = true;
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                answer++;
            }       
        }
        return answer;
    }
}