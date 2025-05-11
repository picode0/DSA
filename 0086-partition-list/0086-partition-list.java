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
    public ListNode partition(ListNode head, int x) {
        ListNode beforex = new ListNode(0);
        ListNode afterx = new ListNode(0);

        ListNode beforeHead = beforex;
        ListNode afterHead = afterx;
        

        while(head!=null){
            if(head.val <x){
                beforex.next = new ListNode(head.val);
                beforex = beforex.next;
            }
            else{
                afterx.next = new ListNode(head.val);
                afterx = afterx.next;
            }
            head = head.next;
        }
        
        beforex.next = afterHead.next;
        return beforeHead.next;

    }
}