class Solution {
    public int[] solution(int[] array) {
        int[] answer = {0, 0};
        for (int i = 0; i < array.length; i++) {
            answer[0] = Math.max(array[i], answer[0]);
            if (array[i] == answer[0]) {
                answer[1] = i;
            }  
        }
        return answer;
    }
}