class Solution {
    public int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String[] dates = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
    public String solution(int a, int b) {
        int total = 0;
        for (int i = 0; i < a; i++) {
            total += days[i];
        }
        
        total += b - 1;


        String answer = dates[total % 7]; 
        return answer;
    }
}