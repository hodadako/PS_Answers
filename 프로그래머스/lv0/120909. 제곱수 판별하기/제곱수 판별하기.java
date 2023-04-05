class Solution {
    public int solution(int n) {
        int answer = 0;
        double d = Double.valueOf(n);
        if (Math.round(Math.sqrt(d)) == Math.sqrt(d)) {
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }
}