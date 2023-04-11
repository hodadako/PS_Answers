class Solution {
    int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGcd(b, a % b); 
        }
    }
    
    public int solution(int a, int b) {
        int answer = 0;
        int common = getGcd(a, b);
        a /= common;
        b /= common;
        
        while (true) {
            if (b == 1) {
                answer = 1;
                break;
            } else if (b % 2 == 0) {
                b /= 2;
            } else if (b % 5 == 0) {
                b /= 5;
            } else {
                answer = 2;
                break;
            }
        }
        return answer;
    }
}