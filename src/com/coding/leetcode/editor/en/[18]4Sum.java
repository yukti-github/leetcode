//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Two Pointers Sorting 👍 4824 👎 580

package com.coding;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int first=0; int second =0; int tar2= 0;
        HashSet<Integer> hashList2;

        List<List<Integer>> finalAns= new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1; j<nums.length; j++){
                first= nums[i];
                second= nums[j];
                tar2= target-(first+second);


                int arr[]= new int[nums.length-2];
                for(int k=0; k<nums.length; k++)
                {
                    if(k<i) arr[k]=nums[k];
                    else if (k>i && k<j) arr[k-1]=nums[k];
                    else if(k>j) arr[k-2]= nums[k];
                }
                hashList2= twoSum(arr,tar2);

                for(int p: hashList2){
                    List<Integer> list3= new ArrayList<>();

                    list3.add(first);list3.add(second); list3.add(p); list3.add(tar2-p);
                  //  System.out.print("out= "+list3);
                    if(checkUnique(list3,finalAns)) finalAns.add(list3);
                }

            }
        }

        return finalAns;


    }

    public static HashSet<Integer> twoSum(int[] nums, int target)
    {
        HashSet<Integer> tempSet= new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        int first;
        for(int i=0; i<nums.length; i++)
        {
             first = nums[i];
            if(tempSet.contains(first)&& !resultSet.contains(first) && !resultSet.contains(target-first)) {
                resultSet.add(first);
            }
            else
                tempSet.add(target-first);
        }
        return resultSet;
    }

    public static boolean checkUnique(List<Integer> list3, List<List<Integer>> finalAns)
    {
        //if(finalAns.size()==0) return true;
        List<Integer> tempList ;
        int counter=1;
        Collections.sort(list3);
        for(int i=0; i<finalAns.size();i++)
        {
            tempList= finalAns.get(i);
            Collections.sort(tempList);
            for(int l=0; l<tempList.size();l++)
            {
                if(tempList.get(l).longValue()==list3.get(l).longValue()) { counter++;}
                if(tempList.get(l).longValue()!=list3.get(l).longValue()) break;
            }
            if(counter==5) {return false;} counter=1;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
