class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(tmp);
        sb.reverse();
        tmp = sb.toString();
        answer = Integer.parseInt(tmp, 3);
        return answer;
    }
}