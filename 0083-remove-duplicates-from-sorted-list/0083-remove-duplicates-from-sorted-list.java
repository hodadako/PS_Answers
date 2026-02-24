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
    LinkedList<ListNode> list = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        search(head);
        solve(null, 0);
        return head;
    }

    void search(ListNode node) {
        if (node == null) return;
        
        list.add(node);
        search(node.next);
        node.next = null;
    }

    void solve(ListNode a, int i) {
        if (i == list.size()) return;
        ListNode node = list.get(i);

        if (a == null) {
            set.add(node.val);
            solve(node, i + 1);
        } else {
            if(set.contains(node.val)) {
                solve(a, i + 1);
            } else {
                set.add(node.val);
                a.next = node;
                solve(node, i + 1);
            }
        }
    }
}