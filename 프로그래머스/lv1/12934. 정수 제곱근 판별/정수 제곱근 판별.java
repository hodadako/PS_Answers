class Solution {
    public long solution(long n) {
        double d = Math.sqrt(n);
        long answer = (long) (d + 1) * (long) (d + 1) ;
        if (d - (int)d > 0) {
            answer = -1;
        }
        return answer;
    }
}