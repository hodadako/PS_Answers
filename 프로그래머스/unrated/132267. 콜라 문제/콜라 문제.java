class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int empty = 0;
        while (n >= a) {
            answer += n / a * b;
            empty = n / a * b + n % a;
            n %= a;
            n = empty;
        }
        return answer;
    }
}