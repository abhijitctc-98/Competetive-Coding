/*
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:

Input: root = [2,1,3], k = 4
Output: true
Example 4:

Input: root = [2,1,3], k = 1
Output: false
Example 5:

Input: root = [2,1,3], k = 3
Output: true
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
*/

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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        
        inOrder(root , list);
        return twoSum(list , k);
    }
    
    private boolean twoSum(List<Integer> list , int target) {
        int l = 0;
        int r = list.size() - 1;
        
        while(l < r) {
            int sum = list.get(l) + list.get(r);
            
            if(sum == target) {
                return true;
            } else if(sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
    
    private void inOrder(TreeNode root , List<Integer> list) {
        if(root == null) {
            return;
        }
        inOrder(root.left , list);
        list.add(root.val);
        inOrder(root.right , list);
    }
}
