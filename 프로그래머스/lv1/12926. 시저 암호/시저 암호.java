class Solution {
    private String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String lower = "abcdefghijklmnopqrstuvwxyz";
    
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (upper.contains(str)) {
                int index = upper.indexOf(str) + n;
                if (index > 25) {
                    index %= 26;
                }
                sb.append(upper.charAt(index));
            } else if (lower.contains(str)){
                int index = lower.indexOf(str) + n;
                if (index > 25) {
                    index %= 26;
                }
                sb.append(lower.charAt(index));
            } else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}