import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reverse = 0;
        int a = x;
        ArrayList<Integer> list = new ArrayList<>();
        while (a != 0) {
            int pop = a % 10;
            a /= 10;
            list.add(pop);
        }

        for (int i : list) {
            reverse = reverse * 10 + i;
        }

        return x == reverse;
    }
}