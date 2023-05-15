class Solution {
    public int solution(int[] num_list) {
        int sumSq = 0;
        int mul = 1;
        int answer = 0;
        for (int i = 0; i < num_list.length; i++) {
            mul *= num_list[i];
            sumSq += num_list[i];
        } 
        sumSq *= sumSq;
        if (sumSq > mul) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}