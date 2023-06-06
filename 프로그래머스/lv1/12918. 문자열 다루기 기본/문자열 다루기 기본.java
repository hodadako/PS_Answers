class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int n = s.length();
        if (n != 4 && n != 6) {
            answer = false;
        } else {
            for (int i = 0; i < n; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}