class Solution {
    
    public int getGcd(int a, int b) {
        if  (b == 0){
            return a;
        }  else {
            return getGcd(b, a % b);
        }
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int lcm = denom1 * denom2 / getGcd(denom1, denom2);
        int totalNumer = numer1 * (lcm / denom1) + numer2 * (lcm / denom2);
        int gcdOfDL = getGcd(totalNumer, lcm);
        if (gcdOfDL == 1) {
            answer[0] = totalNumer;
            answer[1] = lcm;
        } else {
            answer[0] = totalNumer / gcdOfDL;
            answer[1] = lcm / gcdOfDL;
        }

        return answer;
    }
}