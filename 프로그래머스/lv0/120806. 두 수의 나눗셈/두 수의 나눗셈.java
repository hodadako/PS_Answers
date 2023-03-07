class Solution {
    public int solution(double num1, double num2) {
        double result = num1 / num2 * 1000;
        int answer = (int) (result);
        return answer;
    }
}