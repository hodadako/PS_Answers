class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for (int i = 0; i < numLog.length - 1; i++) {
            int delta = numLog[i + 1] - numLog[i];
            if (delta == 1) {
                answer += "w";
            } else if (delta == -1) {
                answer += "s";
            } else if (delta == 10) {
                answer += "d";
            } else {
                answer += "a";
            }
        }
        return answer;
    }
}