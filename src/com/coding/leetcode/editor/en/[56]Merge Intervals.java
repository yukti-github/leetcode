//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics Array Sorting 👍 10485 👎 450

package com.coding;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution  {
    public int[][] merge(int[][] intervals) {
        intervals= sortArray(intervals);
    Stack<Pair> stack = new Stack<Pair>();

    Pair pair;
        stack.push(new Pair(intervals[0][0],intervals[0][1]));

    for(int i=1; i<intervals.length;i++)
    {
        pair= stack.peek();
        if(pair.end>=intervals[i][0])
        {
            stack.pop();
            stack.push(new Pair(pair.start,Math.max(pair.end,intervals[i][1])));
        }
        else{
            stack.push(new Pair(intervals[i][0],intervals[i][1]));
        }
    }
        int[][] result = new int[stack.size()][2];
        Pair pair2;

//        while(!stack.isEmpty())
//        {
//            pair2=stack.pop();
//            System.out.println(pair2.start+ " , "+ pair2.end);
//        }
       // System.out.println("size of stack"+stack.size());
        int size= stack.size();
    for(int i=0; i<size; i++)
    {
     pair2= stack.pop();
     result[i][0]= pair2.start;
     result[i][1]= pair2.end;
    }

//        for(int i=0; i<result.length;i++)
//        {
//            for(int j=0; j< result[0].length;j++)
//            {
//                System.out.print(result[i][j]);
//            }
//            System.out.print("\n");
//        }


        return result;
    }

    public int[][] sortArray(int[][] array)
    {
        Arrays.sort(array,(a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        //System.out.print("***********");
//        for(int i=0; i<array.length;i++)
//        {
//            for(int j=0; j< array[0].length;j++)
//            {
//                System.out.print(array[i][j]);
//            }
//            System.out.print("\n");
//        }
//        System.out.print("***********");
        return array;
    }
}

class Pair{
    int start;
    int end;
    public Pair(int start, int end)
        {
            this.start=start;
            this.end= end;
        }


        }
//leetcode submit region end(Prohibit modification and deletion)
