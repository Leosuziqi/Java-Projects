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
import java.util.*;
class Solution {

    List<Integer> onenode=new ArrayList<Integer>();
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    List<List<Integer>> reverse=new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root!=null) {
            int level = 1;
            travarsal(level, root);
        }
        for(int i=0;i<result.size();i++){
            reverse.add(result.get(result.size()-i-1));
        }
        return reverse;
    }

    public void  travarsal(int level,TreeNode root){
        List<Integer> newlevel=new ArrayList<Integer>();
        if (level==1){
            newlevel.add(root.val);
            result.add(newlevel);
        }else if(result.size()<level){

            newlevel.add(root.val);
            result.add(newlevel);
        } else{
            result.get(level-1).add(root.val);
        }

        if(root.left==null&&root.right==null) {
            return;
        }
        if (root.left!=null) {
            travarsal(level+1,root.left);
        }
        if (root.right!=null) {
            travarsal(level+1,root.right);
        }


    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}