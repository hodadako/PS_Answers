class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        String[] strArr = s.split(" ");
        for (String k : strArr) {
            max = Math.max(max, Integer.parseInt(k));
            min = Math.min(min, Integer.parseInt(k));
        }
        sb.append(String.valueOf(min));
        sb.append(' ');
        sb.append(String.valueOf(max));
        return sb.toString();
    }
}