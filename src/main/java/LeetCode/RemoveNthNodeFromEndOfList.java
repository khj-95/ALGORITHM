package LeetCode;


import java.util.*;

/*Definition for singly-linked list.*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> m = setStack(head);
        ListNode l;
        ListNode r = null;
        int i = 1;
        while (true) {
            ListNode now = m.pop();
            if (m.isEmpty() && i == n) {
                head = r;
                return head;
            }
            if (i < n) {
                r = now;
            }
            if (i == n + 1) {
                l = now;
                break;
            }
            i++;
        }
        l.next = r;
        return head;
    }

    private Stack<ListNode> setStack(ListNode head) {
        Stack<ListNode> m = new Stack<>();
        m.add(head);
        ListNode now = head;
        while (Objects.nonNull(now.next)) {
            m.add(now.next);
            now = now.next;
        }
        return m;
    }
}