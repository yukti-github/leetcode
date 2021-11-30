//Given the head of a singly linked list, return true if it is a palindrome.
//
//
// Example 1:
//
//
//Input: head = [1,2,2,1]
//Output: true
//
//
// Example 2:
//
//
//Input: head = [1,2]
//Output: false
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [1, 10⁵].
// 0 <= Node.val <= 9
//
//
//
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked
//List Two Pointers Stack Recursion 👍 7041 👎 488

package com.coding;
import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isPalindrome(ListNode head) {
        ListNode current= head;
        int size=1;
        int revStart=0;
        int counter=1;
        while(current.next!=null)
        {
            current= current.next;
            size++;
        }
        if(size==1) return true;
        current= head;
        // System.out.print(counter+" "+counter/2);
        if(size%2==0)
        {
            revStart= size/2;
        }
        else
        {
            revStart= size/2 +1 ;
        }
//    for(int i=1; i<=size; i++)
//    {
//        if(i<revStart) current= current.next;
//        if(i==revStart) temp= current.next;
//    }
        ListNode fwd=null; ListNode random= null;ListNode random2= null; ListNode prev=null;
        int i=1;
        while(current!=null)
        { System.out.println("i = "+i+" ,"+current.val);
            if(i<revStart) current= current.next;
            if(i==revStart) {prev= random2=current; current= random= current.next;}
            if(i>revStart && i<size)
            {
                fwd= current.next;
                current.next = prev;
                prev= current;
                current= fwd;
            }
            if(i==size) {random2.next=current; current.next=prev;
                random.next=null; current= random.next;}
            i++;
        }

        current= head;
        for(int l=1;l<=revStart;l++)
        {
            current= current.next;
        }
        ListNode start2= current;
        ListNode start1= head;
        int pointer = 1;
        while(start2!=null && pointer<=revStart)
        {
            if(start1.val!=start2.val) return false;
            start1= start1.next;
            start2= start2.next;
            pointer++;
        }
        System.out.print(" "+current.val);
//        while(current!=null) {
//            System.out.println(current.val);
//            current = current.next;
//
//        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
