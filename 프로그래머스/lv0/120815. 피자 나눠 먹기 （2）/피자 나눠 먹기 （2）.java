class Solution {
    public int gcd(int a, int b){
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    
    public int solution(int n) {
        int answer = 0;
        int gcd = gcd(n, 6);
        answer = n / gcd;
        return answer;
    }
}