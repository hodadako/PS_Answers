// 5자리 781 4자리 156 3자리 31 2자리 6

class Solution {
    public int solution(String word) {
        int[] key = {781, 156, 31, 6, 1};
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'A') {
                answer += 1;
            } else if (word.charAt(i) == 'E') {
                answer += key[i] + 1;
            } else if (word.charAt(i) == 'I')  {
                answer += key[i] * 2 + 1;
            } else if (word.charAt(i) == 'O') {
                answer += key[i] * 3 + 1;
            } else {
                answer += key[i] * 4 + 1;
            }
        }
        return answer;
    }
}