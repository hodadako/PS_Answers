import java.util.*;

class Solution {
    public int evenQ(LinkedList<Integer> queue1, LinkedList<Integer> queue2, long total, long sum, int n) {
        int count = 0;
        boolean flag = false;
        while (sum != total / 2) {
            if (sum > total / 2) {
                int tmp1 = queue1.removeFirst();
                queue2.addLast(tmp1);
                sum -= tmp1;
                count += 1;
            } else if (sum < total / 2){
                int tmp2 = queue2.removeFirst();
                queue1.addLast(tmp2);
                sum += tmp2;
                count += 1;
            }
            
            if (count > n * 4) {
                flag = true;
                break;
            }
        }
        
        if (flag) {
            count = -1; 
        }
        return count;
    }
    
    public int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        LinkedList<Integer> q3 = new LinkedList<>();
        LinkedList<Integer> q4 = new LinkedList<>();
        
        int n = queue1.length;
        long total = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i] + queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.addLast(queue1[i]);
            q2.addLast(queue2[i]);
            q3.addLast(queue1[i]);
            q4.addLast(queue2[i]);
        }

        int answer = 0;
        int n1 = evenQ(q1, q2, total, sum1, n);
        
        
        int n2 = evenQ(q4, q3, total, sum2, n);
        System.out.println(n1 + " " + n2);
        if (n1 == -1 && n2 == -1) {
            answer = -1;
        } else {
            if (n1 == -1) {
                answer = n2;
            } else if (n2 == -1) {
                answer = n1;
            } else {
                answer = Math.min(n2, n1);
            }
        }
        return answer;
    }
}