//Given the root of a binary tree, imagine yourself standing on the right side 
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 53
//29 👎 292

package com.coding;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();

        TreeNode seperator = new TreeNode();
        seperator.val= 101;

        if(root==null) return list;

        queue.add(root);
        queue.add(seperator);
        TreeNode removed;
        TreeNode peeked;

        while(!queue.isEmpty())
        {
            removed= queue.remove();
           peeked= queue.peek();
            if(removed.val!=seperator.val )
            {
              if(removed.left!=null)  queue.add(removed.left);
                if(removed.right!=null)   queue.add(removed.right);

            }
            if(removed.val==seperator.val)
                queue.add(seperator);

            if(removed.val==seperator.val && queue.size()==1)
            {
                break;
            }

            if(peeked.val==seperator.val)
            {
                list.add(removed.val);
            }
        }


    return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
