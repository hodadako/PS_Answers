class Solution {
    public int[] solution(int[] num_list) {
        int sizeOfArray = num_list.length - 1;
        int[] answer = num_list;
        
        for (int i = 0; i < sizeOfArray / 2; i++) {
            int tmp;
            tmp = answer[i];
            answer[i] = answer[sizeOfArray - i];
            answer[sizeOfArray - i] = tmp;
        }
        return answer;
    }
}