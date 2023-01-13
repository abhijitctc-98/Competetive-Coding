class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

/*
In the above solution, I have simply created a dummy node that acts as a placeholder for the head of the list. This is useful in cases where the head node needs to be removed.

I used two pointers, first and second, to traverse the list. The first pointer is advanced n+1 steps ahead of the second pointer. This puts the first pointer at a position n+1 nodes away from the end of the list.

Then I move both pointers together until the first pointer reaches the end of the list. At this point, the second pointer will be pointing at the nth node from the end, which is the node that needs to be removed.

Finally, I update the next pointer of the node before the nth node to point to the node after the nth node, effectively removing it from the list.

The time complexity of this solution is O(L) where L is the length of the linked list and space complexity is O(1)

*/

Optimised Approach
------------------------

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode first = head;
        while (first != null) {
            len++;
            first = first.next;
        }
        len -= n;
        first = dummy;
        while (len > 0) {
            len--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}

/*
In this optimization, we'll calculate the length of the linked list first and then remove the nth node from the start of the list.
This way we eliminate the need for two pointers and only need to traverse the list once.

This way the time complexity of this solution remains O(L) where L is the length of the linked list
and Space Complexity is O(1) and it eliminates the need for two pointers.
*/
