class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {

            // Find kth node
            ListNode kth = findKthNode(temp, k);

            // Less than k nodes left
            if (kth == null) {
                if (prevLast != null)
                    prevLast.next = temp;
                break;
            }

            // Save next group
            ListNode nextNode = kth.next;

            // Cut current group
            kth.next = null;

            // Reverse current group
            ListNode newHead = reverse(temp);

            // First group
            if (temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }

            // Current tail connects to next group
            temp.next = nextNode;

            // Update pointers
            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }

    // Find kth node from temp
    private ListNode findKthNode(ListNode temp, int k) {
        k--;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    // Reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }
}