class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            double b = numbers[i];
            answer += b;
        }
        answer /= length;
        return answer;
    }
}