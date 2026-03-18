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

        List<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }

        int temp = list.get(k-1);

        list.set(k-1, list.get(list.size()-k));

        list.set(list.size()-k, temp);

        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;

        for(int num: list){

            ListNode newNode = new ListNode(num);
            dummy.next = newNode;
            dummy = dummy.next;
        }
        return ret.next;
    }
}