class Solution {

    boolean curseCheck (int i) {
        if (i % 3 == 0) {
            return false;
        } else if (String.valueOf(i).contains("3")) {
            return false;
        } else {
            return true;
        }
    }
    
    public int solution(int n) {
        int[] decodeArr = new int[n + 1];
        decodeArr[0] = 0;
        int count = 1;
        int num = 1;
        while (true) {
            if (curseCheck(num)) {
                decodeArr[count] = num;
                count += 1;
                num += 1; 
            } else {
                num += 1;
            } 
            
            if (count == n + 1) {
                break; 
            }
        }
        return decodeArr[n];
    }
}