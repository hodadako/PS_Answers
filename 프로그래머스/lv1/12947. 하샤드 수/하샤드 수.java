class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += Character.getNumericValue(s.charAt(i));
        }
        boolean answer = true;
        if (x % total != 0) {
            answer = false;
        }
        return answer;
    }
}