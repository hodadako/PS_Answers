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
    ListNode head;
    ListNode temp;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        merge(list1, list2);
        return head;
    }

    public void merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            temp.next = l2;
            return;
        } else if (l2 == null) {
            temp.next = l1;
            return; 
        }

        if (l1.val <= l2.val) {
            if (head == null) {
                head = l1;
                temp = l1;
            } else {
                temp.next = l1;
                temp = l1;
            }
            merge(l1.next, l2);
        } else {
            if (head == null) {
                head = l2;
                temp = l2;
            } else {
                temp.next = l2;
                temp = l2;
            }
            merge(l1, l2.next);
        }
    }
}