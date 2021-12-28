class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Helper> minHeap= new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        int result[] = new int[2];

        for(int i=0; i<nums.size();i++)
        {
            minHeap.add(new Helper(i,0,nums.get(i).get(0)));
            max = nums.get(i).get(0)>max ? nums.get(i).get(0):max;
        }
        min = minHeap.peek().val;

        result[0]=min;
        result[1]=max;
        Helper current;
        int temp=Integer.MIN_VALUE;

        while(minHeap.size()==nums.size())
        {
            current= minHeap.poll();

            if(current.col<nums.get(current.row).size()-1)
            {
                temp= nums.get(current.row).get(current.col+1);
                minHeap.add(new Helper(current.row,current.col+1,temp));

                max = temp>max ? temp:max;
                min = minHeap.peek().val;
                if(result[1]-result[0]>max-min)
                {
                    result[1]=max;
                    result[0]=min;
                }

            }


        }
        return result;
    }
}

class Helper{
    int row;
    int col;
    int val;

    public Helper(int row, int col, int val)
    {
        this.row=row;
        this.col=col;
        this.val=val;
    }
}