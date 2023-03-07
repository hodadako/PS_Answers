class Solution {
    public int[] solution(int[] numbers) {
        int lengthOfNumbers = numbers.length;
        int[] answer = new int[lengthOfNumbers];
        for (int i = 0; i < lengthOfNumbers; i++) {
            answer[i] = numbers[i] * 2;
        }
        return answer;
    }
}