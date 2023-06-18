class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (i % m == p - 1) {
                answer.append(sb.charAt(i));
            }
            
            if (answer.length() == t) break;
        }
        return answer.toString().toUpperCase();
    }
}