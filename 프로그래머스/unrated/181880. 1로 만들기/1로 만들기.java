class Solution {
    public int divide(int n) {
        int result = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n - 1) / 2;
            }
            result += 1;
        }
        return result;
    }
    
    public int solution(int[] num_list) {
        int answer = 0;
        for (int i: num_list) {
            answer += divide(i);
        }
        return answer;
    }
}