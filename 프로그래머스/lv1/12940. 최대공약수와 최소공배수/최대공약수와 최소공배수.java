class Solution {
    private int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        } 
        return getGcd(b, a % b);
    }
    
    public int[] solution(int n, int m) {
        int k = getGcd(n, m);
        int[] answer = {k, n * m / k};
        return answer;
    }
}