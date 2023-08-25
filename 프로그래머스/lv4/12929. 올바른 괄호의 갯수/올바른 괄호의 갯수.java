class Solution {
    public int solution(int n) {
        long total = 1;
        for (int i = n + 1; i <= 2 * n; i++) {
            total *= i;
        }
        
        for (int i = 1; i <= n; i++) {
            total /= i;
        }
        total /= n + 1;
        return (int) total;
    }
}