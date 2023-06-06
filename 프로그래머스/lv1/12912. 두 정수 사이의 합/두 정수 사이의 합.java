class Solution {
    long add(int x, int y) {
        long answer = 0;
        int a = Math.max(x, y);
        int b = Math.min(x, y);
        if (b > 0) {
            for (int i = b; i <= a; i++){
                answer += i;
            }
        } else if (b < 0 && a > 0) {
            for (int i = 0; i <= a; i++) {
                answer += i;
            } 
            for  (int i = 0; i >= b; i--) {
                answer += i;
            }
        } else {
            for (int i = b; i <= a; i++) {
                answer += i; 
            }
        }        
        return answer;
    }
        
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a == b) {
            answer = a;
        } else {
            answer = add(a, b);
        }
        return answer;
    }
}