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
    public ListNode swapNodes(ListNode head, int k) {
        // 1 2 3 4 5 6 7 8 9
        
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = new ListNode(0);
        fast.next = head; 
        
        for(int i=0;i<k;i++)
            fast = fast.next;

        ListNode firstSwap = fast;

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        int temp = slow.val;
        slow.val = firstSwap.val;
        firstSwap.val = temp;

        return head;

    }
}