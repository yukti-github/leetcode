/*

Given a singly-linked list and a positive number k, reverse every alternate group of k nodes. The swapping of data is not allowed, only links should be changed.


Input:

Linked List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> 9 —> 10 —> null
k = 2

Output: 2 —> 1 —> 3 —> 4 —> 6 —> 5 —> 7 —> 8 —> 10 —> 9 —> null


Input:

Linked List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> 9 —> 10 —> null
k = 3

Output: 3 —> 2 —> 1 —> 4 —> 5 —> 6 —> 9 —> 8 —> 7 —> 10 —> null


Input:

Linked List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> 9 —> 10 —> null
k >= 10

Output: 10 —> 9 —> 8 —> 7 —> 6 —> 5 —> 4 —> 3 —> 2 —> 1 —> null

*/

class Solution
{
	/*
		A singly-linked list node is defined as:

		class Node {
			int data;		// data field
			Node next;		// pointer to the next node

			Node() {}
			Node(int data) { this.data = data; }
			Node(int data, Node next) { this.data = data; this.next = next; }
		}
	*/

    public static Node reverseAlternatingKNodes(Node head, int k)
    {
        Node current= head;
        if(head==null) return null;
        Node prev= null;
        int size=1;
        while(current.next!=null)
        {
            current= current.next;
            size++;
        }
        if(size==1) return head;
        if(k>=size)
        {
            head= reverseSubpart(head, size);
            return head;
        }
        current= head;
        int div=0;
        // System.out.print("size= "+size+"\n");
        for(int i=0; i< size-1; i++)
        {

            div= i/k;
            if(i==0)
            {
                head= reverseSubpart(head, k);
                // System.out.print("head= "+head.data);
                current= head;
            }

            if(i!=0 && i%k==0 && div%2==0)
            {
                prev.next= reverseSubpart(current, k);
                current= prev.next;

            }
            // System.out.print("i="+i+" , current= "+current.data+"\n");
            prev= current;
            if(current.next==null)break; else current= current.next;
        }
        Node temp =head;
        int p=0;

        while(p<size){

            System.out.print(temp.data+ " ");
            temp= temp.next;
            p++;
        }
        return head;
    }


    public static Node reverseSubpart(Node head, int k)
    {   int i=1;
        int j=1;

        int size=1;
        Node curr=head;
        while(curr.next!=null)
        {
            curr= curr.next;
            size++;
        }
        if(size<k){ head= reverse2Subpart(head,size); return head;};

        Node xyz= head;
        Node end= null;
        Node prev= head;
        Node current= head.next;
        Node fwd=null;
        while(i<k)
        {
            fwd= current.next;
            current.next = prev;
            prev= current;
            current= fwd;
            i++;
        }
        head= prev;
        end= xyz;
        end.next= current;
        //System.out.print("head="+head.data+" , end= "+end.data+" == "+end.next.data+"\n");

        // while(j<=k)
        // {
        //     System.out.print("head from below =" +head.data+"\n");
        //     head= head.next;
        //     j++;
        // }
        // System.out.print("head from below =" +head.data+"\n");
        return head;
    }
    public static Node reverse2Subpart(Node head, int k)
    {
        Node cur= head;
        Node temp1= head;
        Node prev= cur;
        cur= cur.next;
        Node fwd= null;
        while(cur!=null)
        {
            fwd= cur.next;
            cur.next= prev;
            prev= cur;
            cur= fwd;
        }
        head= prev;
        temp1.next= null;
        return head;
    }
}


