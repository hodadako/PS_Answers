class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;
        int pos = 1;
        int coverage = 2 * w + 1;
        
        while (pos <= n) {
            if (index < stations.length && stations[index] - w <= pos) {
                pos = stations[index] + w + 1;
                index++;
            } else {
                answer++;
                pos += coverage;
            }
        }
        

        return answer;
    }
}