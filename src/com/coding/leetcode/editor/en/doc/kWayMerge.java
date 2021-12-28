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

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        ListNode head=null;

        ListNode current =null;

        for(int i=0; i<lists.length;i++)
        {
            if(lists[i]!=null)
                heap.add(lists[i]);
        }

        if(heap.size()==0) return head;

        ListNode temp;


        while(heap.size()>0)
        {

            temp= heap.peek();
            if(head==null){
                head=current= new ListNode(heap.peek().val,null);
            }
            heap.poll();
            if(temp.next!=null) heap.add(temp.next);

            if(heap.size()>0) {

                current.next= new ListNode(heap.peek().val,null);
                current= current.next;

            }

        }

        return head;
    }

}