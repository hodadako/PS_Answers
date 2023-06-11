class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            answer[s.length() - 1 - i] = Character.getNumericValue(s.charAt(i));
        }
        return answer;
    }
}