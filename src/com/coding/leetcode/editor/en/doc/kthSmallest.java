class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Pair> minheap= new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));

        for(int i=0; i<matrix.length; i++)
        {
            minheap.add(new Pair(matrix[i][0],i,0));

        }

        Pair current=null;

        while(k>0)
        {
            current= minheap.poll();

            if(current.index<matrix[0].length-1)
            {
                minheap.add(new Pair(matrix[current.row][current.index+1], current.row,current.index+1 ));
            }
            k--;
        }

        return current.val;
    }
}




class Pair{

    int val;
    int row;
    int index;

    public Pair(int val, int row, int index)
    {
        this.val= val;
        this.row= row;
        this.index=index;
    }
}