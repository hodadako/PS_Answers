import java.util.Arrays;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        long[] aCumSum = new long[len];
        long[] bCumSum = new long[len];
        long aSum = 0, bSum = 0; 
        
        long aMaxSum = 0, bMaxSum = 0;
        long aMinSum = Long.MAX_VALUE, bMinSum = Long.MAX_VALUE;
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                aSum += sequence[i] * -1;
                bSum += sequence[i];
            } else {
                aSum += sequence[i];
                bSum += sequence[i] * -1;
            }
            
            aCumSum[i] = aSum; 
            bCumSum[i] = bSum;
            
            aMaxSum = Math.max(aMaxSum, aSum);
            bMaxSum = Math.max(bMaxSum, bSum);
            
            aMinSum = Math.min(aMinSum, aSum);
            bMinSum = Math.min(bMinSum, bSum);
        }
    
        return Math.max(aMaxSum - aMinSum, bMaxSum - bMinSum);
    }
}