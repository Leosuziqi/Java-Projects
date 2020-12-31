
import java.util.*;

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

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp=new TreeNode();
        temp=root;
        while (temp!=null) {
            if (temp.val == val) {
                return temp;
            } else if (temp.val <>val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return temp;
    }
}



import java.util.ArrayList;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Integer> lengthlist=new ArrayList<Integer>();
        for (int i=0;i<s.length()-1;i++){
            Boolean flag=false;
            do{
                int length=1;
                for (int j=i;j<i+length;j++){
                    if (s.charAt(i+length)==s.charAt(j)||i+length==s.length()) {
                        flag=true;
                        lengthlist.add(length);
                        break;
                    }
                }
                length++;
            }while(!flag);
        }

        int shortest=lengthlist.get(0);
        for(int j=0;j<lengthlist.size();j++) {
            if (lengthlist.get(j) < shortest) {
                shortest = lengthlist.get(j);
            }
        }
        return shortest;
    }

}


import java.util.Arrays;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        for(int i=0;i<s.length();i++) {
            String shorten=s.substring(i);
            char[] schar=shorten.toCharArray();
            for (int j=0; j<shorten.length();j++) {
                if (schar[0]==schar[j]
            }

            }
        }
        return length;
    }

}