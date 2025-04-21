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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);

        for(ListNode list: lists)
            if(list!=null)
                pq.add(list);

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(!pq.isEmpty()){
            ListNode poll = pq.poll();
            System.out.println(poll.val);
            dummy.next = poll;
            dummy = dummy.next;
            if(poll.next!=null)
                pq.add(poll.next);
        }
        return head.next;



    }
}