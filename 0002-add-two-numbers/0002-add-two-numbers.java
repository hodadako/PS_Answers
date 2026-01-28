import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        ListNode t1 = l1;
        while (true) {
            q1.add(t1.val);
            t1 = t1.next;
            if (t1 == null) {
                break;
            }
        }

        LinkedList<Integer> q2 = new LinkedList<>();
        ListNode t2 = l2;
        while (true) {
            q2.add(t2.val);
            t2 = t2.next;
            if (t2 == null) {
                break;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        int up = 0;
        while (true) {
            int a = 0;
            int b = 0;
            if (!q1.isEmpty()) {
                a = q1.poll();
            }
            if (!q2.isEmpty()) {
                b = q2.poll();
            }
            if (a + b + up >= 10) {
                list.add((a + b + up) % 10);
                up = 1;
            }  else {
                list.add((a + b + up));
                up = 0;
            }

            if (q1.isEmpty() && q2.isEmpty()) {
                break;
            }
        }
        if (up != 0) {
            list.add(up);
        }

        ListNode answer = new ListNode();
        ListNode temp = answer;
        while (!list.isEmpty()) {
            int now = list.poll();
            temp.val = now;
            if (!list.isEmpty()) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return answer;
    }
}