//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 👍 3636 👎 97

package com.coding;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean checkInclusion(String s1, String s2) {
      if(s1.length() >s2.length())
          return false;

      Map<Character,Integer> s1map= new HashMap<Character,Integer>();

      for(int i=0; i<s1.length(); i++)
      {
       s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i),0) + 1);
      }



        int start=0, end=0;
        for(int i=0; i<s2.length();i++)
      {
          end=i;
          if(!s1map.containsKey(s2.charAt(i)))
          {
             while(start!=end) {
                 s1map.put(s2.charAt(start),s1map.get(s2.charAt(start))+1);
                 start++;
             }
             start++;

          }
           if(s1map.containsKey(s2.charAt(i)) && s1map.get(s2.charAt(i))<=0)
          {
              while(s1map.get(s2.charAt(i))<=0)
              {
                  s1map.put(s2.charAt(start),s1map.get(s2.charAt(start))+1);
                  start++;
              }

          }
           if(s1map.containsKey(s2.charAt(i)) && s1map.get(s2.charAt(i))>0)
          {
              s1map.put(s2.charAt(i),s1map.get(s2.charAt(i))-1);
          }
          System.out.println(s1map);
          System.out.println("start="+start+", end= "+end+", i= "+i);

          if((end-start+1) == s1.length()) return true;


      }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
