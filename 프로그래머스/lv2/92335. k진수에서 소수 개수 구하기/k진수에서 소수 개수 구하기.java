import java.util.*;

class Solution {
    public boolean check(String s) {
        long tmp = Long.parseLong(s);
        boolean flag = true;
        System.out.println(Math.sqrt(tmp));
        for (int i = 2; i <(int) Math.sqrt(tmp) + 1; i++) {
            if (tmp % i == 0) {
                flag = false;
                break;
            }
        }
        if (tmp == 1) {
            flag = false;
        }
        return flag;
    } 
    
    public int solution(int n, int k) {
        String nStr = Integer.toString(n, k);
        String[] strArr = nStr.split("0");
        int answer = 0;
        for (String s : strArr) {
            if (!s.equals("") && check(s)) {
                answer += 1;
                System.out.println(check(s));
            }
        }

        return answer;
    }
}